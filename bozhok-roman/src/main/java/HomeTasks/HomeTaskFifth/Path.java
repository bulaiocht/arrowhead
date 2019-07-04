package HomeTasks.HomeTaskFifth;

import java.io.File;

public enum Path {

    SRC(String.format("bozhok-roman%ssrc%smain%sresources%ssong.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator)),
    COPY(String.format("bozhok-roman%ssrc%smain%sresources%ssong_copy.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator));

    private String path;


    Path(String path){
        this.path=path;

    }

    public String getPath() {
        return path;
    }
}
