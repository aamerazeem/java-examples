package org.java.examples;
import ai.djl.modality.cv.DetectedObjects;
import ai.djl.modality.cv.ImageVisualization;
import ai.djl.modality.cv.util.BufferedImageUtils;
import ai.djl.mxnet.zoo.MxModelZoo;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeepJavaExample {
    public static void main(String[] args) throws Exception{
       Path path = Paths.get("/Users/azeema/devops-git/djl/examples/src/main/resources/nfl.jpg");
        // Get image file path
        BufferedImage img = BufferedImageUtils
                .fromFile(path);
        //Get resnet model from model zoo.
        ZooModel<BufferedImage, DetectedObjects> model = 
                MxModelZoo.SSD.loadModel(new ProgressBar());
        //Create a new predictor from model and predict on image.
        DetectedObjects predictResult = model.newPredictor().predict(img);
        // Draw Bounding boxes on image
        ImageVisualization.drawBoundingBoxes(img, predictResult);
        //Save result
        ImageIO.write(img, "png", new File("ssd.png"));
        model.close();
    }
}