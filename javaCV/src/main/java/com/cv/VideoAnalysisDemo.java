package com.cv;

//import org.bytedeco.javacv.*;
//import org.bytedeco.opencv.global.opencv_core;
//import org.bytedeco.opencv.global.opencv_imgproc;
//import org.bytedeco.opencv.opencv_core.Mat;
//import org.bytedeco.opencv.opencv_core.Rect;
//import org.bytedeco.opencv.opencv_core.RectVector;
//import org.bytedeco.opencv.opencv_core.Scalar;
//import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
//
//public class VideoAnalysisDemo {
//    public static void main(String[] args) {
//
//        // 加载级联分类器文件
//        CascadeClassifier classifier = new CascadeClassifier("/Users/michael/IdeaProjects/javaDemo/javaCV/src/main/java/com/cv/haarcascade_fullbody.xml");
//
//        // 打开视频文件
//        FrameGrabber grabber = new FFmpegFrameGrabber("/Users/michael/Downloads/aa.mp4");
//        try {
//            grabber.start();
//
//            // 创建视频展示窗口
//            CanvasFrame frame = new CanvasFrame("People Counting Demo", CanvasFrame.getDefaultGamma() / grabber.getGamma());
//
//            // 读取视频帧
//            Frame videoFrame;
//            int totalPeopleCount = 0;
//            while ((videoFrame = grabber.grab()) != null) {
//                // 转换为OpenCV的Mat格式
//                OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
//                Mat frameMat = converter.convert(videoFrame);
//
//                // 转换为灰度图像
//                Mat grayImage = new Mat();
//                opencv_imgproc.cvtColor(frameMat, grayImage, opencv_imgproc.COLOR_BGR2GRAY);
//
//                // 进行人体检测
//                RectVector bodies = new RectVector();
//                classifier.detectMultiScale(grayImage, bodies);
//
//                // 绘制人体框
//                for (int i = 0; i < bodies.size(); i++) {
//                    Rect bodyRect = bodies.get(i);
//                    opencv_imgproc.rectangle(frameMat, bodyRect, new Scalar(0, 255, 0, 0));
//                }
//
//                // 更新客流人数
//                long peopleCount = bodies.size();
//                totalPeopleCount += peopleCount;
//
//                // 显示客流人数和视频帧
//                System.out.println("当前帧客流人数：" + peopleCount);
//                System.out.println("累计客流人数：" + totalPeopleCount);
//                frame.showImage(converter.convert(frameMat));
//            }
//
//            frame.dispose();
//            grabber.stop();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
