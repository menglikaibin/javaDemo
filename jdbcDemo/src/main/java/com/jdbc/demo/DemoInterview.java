package com.jdbc.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 产品包装信息
 * 长: 68 cm
 *
 * 宽: 70 cm
 *
 * 高: 60 cm
 *
 * 重量: 23 kg
 *
 * 规则
 * 计算
 * 1 in（英寸）= 2.54 cm
 * 1 LB（磅）= 0.454 kg
 * 长度和重量转换时需要向上取整
 * 围长 = 最长边 + (次长边 + 第三边) * 2 （单位 in）
 * 体积重 = 最长边 * 次长边 * 第三边 / 体积重基数 （结果向上取整）
 * 体积重基数：250
 * 实重 = 产品重量（LB）和体积重之间取最大值
 * 类型定义
 * OUT_SPACE：（实重大于150）或（最长边大于108）或（围长大于165）
 * OVERSIZE：（围长大于130，小于等于165）或（最长边大于等于96小于108）
 * AHS：
 * WEIGHT: 实重大于50，小于等于150
 * SIZE: （围长大于105）或（最长边大于等于48，最长边小于108）或（次长边大于等于30）
 * 若两种类型都符合，则都输出
 * 当满足 OUT_SPACE 类型，不再判断 OVERSIZE 或 AHS；当满足 OVERSIZE，不再判断 AHS；
 * 关系：OUT_SPACE > OVERSIZE > AHS
 * 要求
 * 请实现类型的输出
 *
 * class Main()
 * {
 *     public function test(float $length, float $width, float $height, float $weight): array
 *     {
 *
 *     }
 * }
 *
 * $obj = new Main();
 * var_dump($obj->test(68, 70, 60, 23));
 * 例如:
 *
 * 输入[68, 70, 60, 23], 输出[AHS-WEIGHT, AHS-SIZE]
 * 输入[114.50, 42, 26, 47.5], 输出[AHS-WEIGHT]
 * 输入[162, 60, 11, 14], 输出[AHS-SIZE]
 * 输入[113, 64, 42.5, 35.85], 输出[OVERSIZE]
 * 输入[114.5, 17, 51.5, 16.5], 输出[]
 */
public class DemoInterview {

    String OUT_SPACE = "OUT_SPACE";
    String OVERSIZE = "OVERSIZE";
    String AHS_WEIGHT = "AHS-WEIGHT";
    String AHS_SIZE = "AHS-SIZE";


    public static void main(String[] args) {
        DemoInterview demoInterview = new DemoInterview();
        System.out.println(demoInterview.test(68, 70, 60, 23));
        System.out.println(demoInterview.test(114.50, 42, 26, 47.5));
        System.out.println(demoInterview.test(162, 60, 11, 14));
        System.out.println(demoInterview.test(113, 64, 42.5, 35.85));
        System.out.println(demoInterview.test(114.5, 17, 51.5, 16.5));
    }

    public List<String> test(double length, double width, double height, double weight) {
        // 转换重量
        double weightKg = 0.454 * weight;

        // 计算围长
        double[] list = {length, width, height};
        // 最长边
        Arrays.sort(list);
        double maxLength = list[2];

        // 围长
        double aroundLength = maxLength + (list[0] + list[1]) * 2;

        // 体积重
        double lengthm = length * 2.45 / 100;
        double widthm = width * 2.45 / 100;
        double heightm = height * 2.45 / 100;
        double basicWeight = 250;
        double allWeight = Math.ceil(lengthm * widthm * heightm / basicWeight);
        double actualWeight = Math.max(allWeight, weightKg);

        // 结果集
        List<String> result = new ArrayList<>();
        if (actualWeight > 150 || maxLength > 108 || aroundLength > 165) {
            result.add(OUT_SPACE);
            return result;
        }
        if ((aroundLength > 130 && aroundLength < 165) || (maxLength >= 96 && maxLength < 108)) {
            result.add(OVERSIZE);
            return result;
        }

        if (actualWeight > 50 && actualWeight <= 150) {
            result.add(AHS_WEIGHT);
        }
        if (aroundLength > 105 || (maxLength >= 48 && maxLength < 108) || list[1] >= 30) {
            result.add(AHS_SIZE);
        }

        return result;
    }

}
