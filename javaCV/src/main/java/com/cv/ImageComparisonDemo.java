package com.cv;


//import org.bytedeco.opencv.global.opencv_core;
//import org.bytedeco.opencv.global.opencv_imgcodecs;
//import org.bytedeco.opencv.global.opencv_imgproc;
//import org.bytedeco.opencv.opencv_core.Mat;
//import org.bytedeco.opencv.opencv_core.Size;
//
//import static org.bytedeco.javacv.JavaCV.norm;
//
///**
// * @author 吴凯斌
// * 创建时间 2024/3/12 14:47
// */
//public class ImageComparisonDemo {
//    public static void main(String[] args) {
//        // 读取两张图片
//        Mat image1 = opencv_imgcodecs.imread("/Users/michael/Desktop/图片/cc.jpeg");
//        Mat image2 = opencv_imgcodecs.imread("/Users/michael/Desktop/图片/cc_副本2.jpeg");
//
//        // 调整图像大小为相同尺寸
//        int width = Math.min(image1.cols(), image2.cols());
//        int height = Math.min(image1.rows(), image2.rows());
//
//        Mat resizedImage1 = new Mat();
//        Mat resizedImage2 = new Mat();
//
//        opencv_imgproc.resize(image1, resizedImage1, new Size(width, height));
//        opencv_imgproc.resize(image2, resizedImage2, new Size(width, height));
//
//        // 转换为灰度图像
//        Mat grayImage1 = new Mat();
//        Mat grayImage2 = new Mat();
//        opencv_imgproc.cvtColor(resizedImage1, grayImage1, opencv_imgproc.COLOR_BGR2GRAY);
//        opencv_imgproc.cvtColor(resizedImage2, grayImage2, opencv_imgproc.COLOR_BGR2GRAY);
//
//        // 计算差异图像
//        Mat diffImage = new Mat();
//        opencv_core.absdiff(grayImage1, grayImage2, diffImage);
//
//        // 计算差异值
//        double diff = opencv_core.sumElems(diffImage).get();
//        System.out.println("差异值：" + diff);
//    }
//}
