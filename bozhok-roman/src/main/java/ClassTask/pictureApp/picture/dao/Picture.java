package ClassTask.pictureApp.picture.dao;

import java.io.InputStream;

public class Picture {


    private String fileName;
    private InputStream data;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getData() {
        return data;
    }

    public void setData(InputStream data) {
        this.data = data;
    }

    private Picture(){};
    public static Builder newBuilder() {
        return new Picture().new Builder();
    }
    public class Builder{
        private Builder() {

        }

        public Builder setFileName(String fileName) {
            Picture.this.fileName = fileName;

            return this;
        }
        public Builder setData(InputStream data) {
            Picture.this.data = data;

            return this;
        }
        public Picture build() {
            return Picture.this;
        }
    }


}
