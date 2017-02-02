imageNames = dir(fullfile('.','*.jpg'));
imageNames = {imageNames.name}';
outputVideo = VideoWriter(fullfile('.','output.avi'));
outputVideo.FrameRate = 1;
open(outputVideo)
for ii = 1:length(imageNames)
   img = imread(fullfile('.',imageNames{ii}));
   writeVideo(outputVideo,img)
end

close(outputVideo)