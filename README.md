# screen_capture
Captures screen and creates a video from it.
This repository is created when I couldn't find a simple screen capture program without watermarks and additional steps.
Firstly the Capture.java screenshots the current monitor and names them in increasing order.
Secondly the createvideo.m creates a video from the screenshots, 1 frame per second.

Put both files in the same directory.

Capture.java takes two parameters; the duration between consecutive screen captures in terms of ms and the time the program runs in seconds.
java Capture 1000 10  // takes 10 seconds, 1 screenshot per 1000ms (1 sec)

createvideo.m creates a video using the .jpg files in the same directory. The frame rate is on frame per second, can be changed.
