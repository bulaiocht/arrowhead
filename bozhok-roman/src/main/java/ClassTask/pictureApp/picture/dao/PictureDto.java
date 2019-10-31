package ClassTask.pictureApp.picture.dao;

import java.util.Date;

public class PictureDto {
    private long id;
    private String fileName;
    private Date date;

    public long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "PictureDto{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", date=" + date +
                '}';
    }

    private PictureDto(){};
    public static PictureDto.Builder newBuilder() {
        return new PictureDto().new Builder();
    }
    public class Builder{
        private Builder() {

        }

        public PictureDto.Builder setId(long id){
            PictureDto.this.id = id;

            return this;
        }

        public PictureDto.Builder setFileName(String fileName) {
            PictureDto.this.fileName = fileName;

            return this;
        }
        public PictureDto.Builder setDate(Date date) {
            PictureDto.this.date = date;

            return this;
        }
        public PictureDto build() {
            return PictureDto.this;
        }
    }
}
