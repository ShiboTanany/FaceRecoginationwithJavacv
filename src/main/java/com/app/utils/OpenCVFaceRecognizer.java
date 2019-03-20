/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.utils;

/**
 *
 * @author shibo
 */
import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;

import org.opencv.face.FisherFaceRecognizer;

import static com.googlecode.javacv.cpp.opencv_core.*;

import com.googlecode.javacv.cpp.opencv_contrib.FaceRecognizer;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_core.MatVector;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_contrib.*;



/**
 * I couldn't find any tutorial on how to perform face recognition using OpenCV
 * and Java, so I decided to share a viable solution here. The solution is very
 * inefficient in its current form as the training model is built at each run,
 * however it shows what's needed to make it work.
 *
 * The class below takes two arguments: The path to the directory containing the
 * training faces and the path to the image you want to classify. Not that all
 * images has to be of the same size and that the faces already has to be
 * cropped out of their original images (Take a look here
 * http://fivedots.coe.psu.ac.th/~ad/jg/nui07/index.html if you haven't done the
 * face detection yet).
 *
 * For the simplicity of this post, the class also requires that the training
 * images have filename format: <label>-rest_of_filename.png. For example:
 *
 * 1-jon_doe_1.png 1-jon_doe_2.png 2-jane_doe_1.png 2-jane_doe_2.png ...and so
 * on.
 *
 * Source: http://pcbje.com/2012/12/doing-face-recognition-with-javacv/
 *
 * @author Petter Christian Bjelland
 */
public class OpenCVFaceRecognizer {
	public static void main(String[] args) {
		args = new String[2];
		args[0] = ".\\\\images";
		args[1] = "C:\\Users\\Dell\\Downloads\\images\\27072262_2207505599472489_6672660423936042843_n.jpg";

		IplImage testImage = cvLoadImage(args[1]);

		File root = new File(args[0] );

		FilenameFilter pngFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".png");
			}
		};

		File[] imageFiles = root.listFiles(pngFilter);

		long n = imageFiles.length;
		MatVector images = new MatVector(n );

		int[] labels = new int[imageFiles.length];

		int counter = 0;
		int label;

		IplImage img;
		IplImage grayImg;

		for (File image : imageFiles) {
			img = cvLoadImage(image.getAbsolutePath());

			label = Integer.parseInt(image.getName().split("\\-")[0]);

			grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);

			cvCvtColor(img, grayImg, CV_BGR2GRAY);

			images.put(counter, grayImg);

			labels[counter] = label;

			counter++;
		}

		IplImage greyTestImage = IplImage.create(testImage.width(), testImage.height(), IPL_DEPTH_8U, 1);

		FisherFaceRecognizer faceRecognizer = FisherFaceRecognizer.create();
        
		// FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
		// FaceRecognizer faceRecognizer = createLBPHFaceRecognizer()

//		faceRecognizer.train(images, labels);
//
//		cvCvtColor(testImage, greyTestImage, CV_BGR2GRAY);
//
//		int predictedLabel = faceRecognizer.predict(greyTestImage);
//
//		System.out.println("Predicted label: " + predictedLabel);
	}

	
}