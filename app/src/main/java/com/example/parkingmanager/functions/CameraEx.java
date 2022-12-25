package com.example.parkingmanager.functions;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import com.example.parkingmanager.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
public class CameraEx {
        private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
        private AppCompatActivity activity;
        private PreviewView previewView;
        private FileEx fileEx;

        public CameraEx(AppCompatActivity activity, PreviewView previewView) {
            cameraProviderFuture = ProcessCameraProvider.getInstance(activity);
            this.activity = activity;
            this.previewView = previewView;
        }

        public void showPreview() {
                previewView.setScaleType(PreviewView.ScaleType.FILL_CENTER);
                cameraProviderFuture.addListener(() -> {
                        try {
                                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                                bindPreview(cameraProvider);
                        } catch (ExecutionException | InterruptedException e) {
                                Log.e("CameraXApp", "Use case binding failed", e);
                        }
                }, ContextCompat.getMainExecutor(this.activity));
        }

        private void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
                Preview preview = new Preview.Builder()
                        .build();

                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build();

                preview.setSurfaceProvider(previewView.getSurfaceProvider());
                Camera camera = cameraProvider.bindToLifecycle(this.activity, cameraSelector, preview);
        }

        public void showBitMapInSeconds(Bitmap bitmap, Long timeToPreview) {
                if(bitmap != null) {
                        previewView.post(() -> {
                                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                        previewView.draw(new Canvas(bitmap));
                                }, timeToPreview);
                        });
                }
        }

        public Bitmap takePicture() {
            return previewView.getBitmap();
        }
}

