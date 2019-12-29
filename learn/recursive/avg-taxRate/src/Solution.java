import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/***
 * 有一组数字｛amount｝
 * 求得误差最小，
 * 调整误差仅限于 taxAmount，
 *
 *
 * **/
public class Solution {


    private static BigDecimal minValue = new BigDecimal("0.01");

    private static BigDecimal taxRate  = new BigDecimal("0.13");

    private static int roundModel =BigDecimal.ROUND_HALF_UP;


    private static  String amount ="amount";

    public List<Map<String, BigDecimal>> maxDepth(List<BigDecimal> amounts) {
        //2位子
        BigDecimal allAmount    = amounts.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        //3位
        BigDecimal allTaxAmount = allAmount.multiply(taxRate).divide(taxRate.add(BigDecimal.ONE),2,roundModel);
        AtomicInteger atomicInteger = new AtomicInteger(0);

        List<Map<String, BigDecimal>> maps = amounts.stream().map(x -> createMap(x,atomicInteger)).collect(Collectors.toList());

        //2位
        BigDecimal everyOneTaxAmountSum = maps.stream().map(x->x.get("taxAmount")).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);

        BigDecimal needAdjustAmount = allTaxAmount.subtract(everyOneTaxAmountSum);

        for (Map<String, BigDecimal> map : maps) {
            if(needAdjustAmount.compareTo(BigDecimal.ZERO)>0){
                if(map.get("d_value").compareTo(BigDecimal.ZERO)>0){
                    needAdjustAmount=needAdjustAmount.subtract(minValue);
                    map.put("taxAmount",map.get("taxAmount").add(minValue));
                    map.put("d_value",map.get("taxAmount3Round").subtract(map.get("taxAmount")));

                }
            }
            if(needAdjustAmount.compareTo(BigDecimal.ZERO)==0){
                return maps;
            }
            if(needAdjustAmount.compareTo(BigDecimal.ZERO)<0){
                if(map.get("d_value").compareTo(BigDecimal.ZERO)<0){
                    needAdjustAmount=needAdjustAmount.add(minValue);
                    map.put("taxAmount",map.get("taxAmount").subtract(minValue));
                    map.put("d_value",map.get("taxAmount3Round").subtract(map.get("taxAmount")));
                }
            }

        }
        return maps;
    }

    private Map<String,BigDecimal> createMap(BigDecimal amount,AtomicInteger index){
        Map<String,BigDecimal> map = new HashMap<>(3);
        BigDecimal taxAmount = amount.multiply(taxRate).divide(taxRate.add(BigDecimal.ONE), 3, roundModel);
        BigDecimal taxAnount2Round = taxAmount.setScale(2,roundModel);
        if(taxAmount.compareTo(taxAnount2Round)>0){
            map.put("d_value",minValue);
        }else if(taxAmount.compareTo(taxAnount2Round)==0){
            map.put("d_value",BigDecimal.ZERO);
        }else{
            map.put("d_value",minValue.negate());
        }
        map.put("amount",amount);
        map.put("taxAmount", taxAmount.setScale(2,roundModel));
        map.put("taxAmount3Round",taxAmount);
        map.put("orgIndex",new BigDecimal(index.incrementAndGet()+""));
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List amounts = Arrays.asList(
                new BigDecimal("27304.2"),
                new BigDecimal("17517.47"),
                new BigDecimal("143914.32"),
                new BigDecimal("15810.8"),
                new BigDecimal("17681.9"),
                new BigDecimal("17922.47"),
                new BigDecimal("18664.56"),
                new BigDecimal("19424.65"),
                new BigDecimal("19002.38"),
                new BigDecimal("39956.46"),
                new BigDecimal("20755.85"),
                new BigDecimal("18376.88"),
                new BigDecimal("19636.61"),
                new BigDecimal("68536.35"),
                new BigDecimal("18002.66"),
                new BigDecimal("26904.95"),
                new BigDecimal("50602.5"),
                new BigDecimal("88772.64"),
                new BigDecimal("16559.24"),
                new BigDecimal("-22475.03"),
                new BigDecimal("33540.7"),
                new BigDecimal("56102.25"),
                new BigDecimal("18929.99"),
                new BigDecimal("19074.77"),
                new BigDecimal("17313.28"),
                new BigDecimal("18375"),
                new BigDecimal("19125.32"),
                new BigDecimal("34447.5")
        );
        List<Map<String, BigDecimal>> results = solution.maxDepth(amounts);
        results.forEach(x->System.out.println(x.get("amount")));
        System.out.println("=====================================");
        results.forEach(x->System.out.println(x.get("taxAmount")));
    }



}