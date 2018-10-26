package com.example.yeunjae.assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class Topic2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);

        //show PDF viewer
        //below uses information provided by https://github.com/barteksc/AndroidPdfViewer
        PDFView pdfView = findViewById(R.id.PDFViewer);
        pdfView.fromAsset("Topic 2.pdf")
                .enableSwipe(true) // allows to swipe to next page
                .swipeHorizontal(false) //makes it move vertically as opposed to horizontally
                .enableDoubletap(true) //allows enlarging by double tapping
                .defaultPage(0) //opens on the first page
                .enableAnnotationRendering(false) // no annotations will be on the pdf viewer
                .password(null) //no password needed
                .scrollHandle(null) //no scroller bar on the side
                .enableAntialiasing(true) // makes it render better for low resolution
                .spacing(0) //the spaces between the pages
                .load();
    }
}

