package com.cv;

//import org.bytedeco.javacv.CanvasFrame;
//import org.bytedeco.opencv.global.opencv_imgproc;
//import org.bytedeco.opencv.opencv_core.*;
//import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
//import org.bytedeco.opencv.opencv_videoio.VideoCapture;
//import org.opencv.videoio.Videoio;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.bytedeco.opencv.global.opencv_highgui.imshow;
//import static org.bytedeco.opencv.global.opencv_highgui.waitKey;
//import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
//import static org.bytedeco.opencv.global.opencv_imgproc.resize;
//import static org.opencv.highgui.HighGui.destroyAllWindows;
//
//public class PedestrianDetection {
//    public static void main(String[] args) {
//        // 加载Haar级联分类器
//        CascadeClassifier classifier = new CascadeClassifier();
//        classifier.load("/Users/michael/IdeaProjects/javaDemo/javaCV/src/main/java/com/cv/haarcascade_fullbody.xml");
//
//        // 打开视频文件
//        VideoCapture videoCapture = new VideoCapture("/Users/michael/Downloads/aa.mp4");
//
//        if (!videoCapture.isOpened()) {
//            System.out.println("无法打开视频文件");
//            return;
//        }
//
//        // 视频帧宽度和高度
//        int frameWidth = (int) videoCapture.get(Videoio.CAP_PROP_FRAME_WIDTH);
//        int frameHeight = (int) videoCapture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
//
//        // 用于去除重复客流的阈值
//        double distanceThreshold = 100.0;
//
//        // 客流列表
//        List<Rect> customers = new ArrayList<>();
//
//        // 逐帧读取视频并进行客流检测和去重
//        Mat frame = new Mat();
//
//        int totalPeopleCount = 0;
//        while (videoCapture.read(frame)) {
//            // 缩放帧图像尺寸以提高检测速度
//            Mat resizedFrame = new Mat();
//            Size newSize = new Size(frameWidth / 2, frameHeight / 2);
//            resize(frame, resizedFrame, newSize);
//
//            // 使用Haar级联分类器进行行人检测
//            Mat grayFrame = new Mat();
//            opencv_imgproc.cvtColor(resizedFrame, grayFrame, opencv_imgproc.CV_BGR2GRAY);
//            RectVector detectedObjects = new RectVector();
//            classifier.detectMultiScale(grayFrame, detectedObjects);
//
//            // 更新客流列表
//            List<Rect> updatedCustomers = new ArrayList<>();
//            for (int i = 0; i < detectedObjects.size(); i++) {
//                Rect rect = detectedObjects.get(i);
//                updatedCustomers.add(rect);
//            }
//
//            // 去除重复客流
//            List<Rect> uniqueCustomers = removeDuplicateCustomers(customers, updatedCustomers, distanceThreshold);
//
//            // 更新客流列表
//            customers = uniqueCustomers;
//
//            // 在帧图像上绘制检测框
//            for (Rect rect : uniqueCustomers) {
//                rectangle(frame, rect, Scalar.RED);
//            }
//
//            // 显示帧图像
//            imshow("Pedestrian Detection", frame);
//            waitKey(1);
//
//            // 更新客流人数
//            long peopleCount = uniqueCustomers.size();
//            totalPeopleCount += peopleCount;
//
//            // 显示客流人数和视频帧
//            System.out.println("当前帧客流人数：" + peopleCount);
//            System.out.println("累计客流人数：" + totalPeopleCount);
//        }
//
//        // 释放资源
//        videoCapture.release();
//        destroyAllWindows();
//    }
//
//    public static List<Rect> removeDuplicateCustomers(List<Rect> existingCustomers, List<Rect> newCustomers, double threshold) {
//        List<Rect> uniqueCustomers = new ArrayList<>();
//
//        for (Rect newCustomer : newCustomers) {
//            boolean isDuplicate = false;
//
//            for (Rect existingCustomer : existingCustomers) {
//                double distance = calculateDistance(existingCustomer, newCustomer);
//
//                if (distance < threshold) {
//                    isDuplicate = true;
//                    break;
//                }
//            }
//
//            if (!isDuplicate) {
//                uniqueCustomers.add(newCustomer);
//            }
//        }
//
//        return uniqueCustomers;
//    }
//
//    public static double calculateDistance(Rect rect1, Rect rect2) {
//        int x1 = rect1.x() + rect1.width() / 2;
//        int y1 = rect1.y() + rect1.height() / 2;
//        int x2 = rect2.x() + rect2.width() / 2;
//        int y2 = rect2.y() + rect2.height() / 2;
//
//        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//    }
//}