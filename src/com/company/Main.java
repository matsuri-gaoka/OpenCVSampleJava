package com.company;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        var path = args[0];
        var srcMat = Imgcodecs.imread(path);

        var grayMat = new Mat();
        Imgproc.cvtColor(srcMat, grayMat, Imgproc.COLOR_BGR2GRAY);

        var binImg = new Mat();
        Imgproc.threshold(grayMat, binImg, 0,255, Imgproc.THRESH_OTSU);

        Imgcodecs.imwrite("./result.png", binImg);
    }
}
