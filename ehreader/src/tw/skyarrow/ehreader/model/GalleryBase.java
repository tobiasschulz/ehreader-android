package tw.skyarrow.ehreader.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import tw.skyarrow.ehreader.R;

public abstract class GalleryBase {
    public static final int CATEGORY_DOUJINSHI = 1;
    public static final int CATEGORY_MANGA = 2;
    public static final int CATEGORY_ARTISTCG = 3;
    public static final int CATEGORY_GAMECG = 4;
    public static final int CATEGORY_WESTERN = 5;
    public static final int CATEGORY_NON_H = 6;
    public static final int CATEGORY_IMAGESET = 7;
    public static final int CATEGORY_COSPLAY = 8;
    public static final int CATEGORY_ASIANPORN = 9;
    public static final int CATEGORY_MISC = 10;

    public abstract void setId(Long id);
    public abstract void setToken(String token);
    public abstract void setTitle(String title);
    public abstract void setSubtitle(String subtitle);
    public abstract void setThumbnail(String thumbnail);
    public abstract void setCount(Integer count);
    public abstract void setRating(Float rating);
    public abstract void setUploader(String uploader);
    public abstract void setCreated(Date date);
    public abstract void setCategory(Integer category);
    public abstract void setSize(Long size);
    public abstract void setTags(String tags);

    public void setCategory(String category) {
        if (category.equals("Doujinshi")){
            setCategory(CATEGORY_DOUJINSHI);
        } else if (category.equals("Manga")){
            setCategory(CATEGORY_MANGA);
        } else if (category.equals("Artist CG Sets")){
            setCategory(CATEGORY_ARTISTCG);
        } else if (category.equals("Game CG Sets")){
            setCategory(CATEGORY_GAMECG);
        } else if (category.equals("Western")){
            setCategory(CATEGORY_WESTERN);
        } else if (category.equals("Non-H")){
            setCategory(CATEGORY_NON_H);
        } else if (category.equals("Image Sets")){
            setCategory(CATEGORY_IMAGESET);
        } else if (category.equals("Cosplay")){
            setCategory(CATEGORY_COSPLAY);
        } else if (category.equals("Asian Porn")){
            setCategory(CATEGORY_ASIANPORN);
        } else {
            setCategory(CATEGORY_MISC);
        }
    }

    public abstract Integer getCategory();

    public int getCategoryString() {
        switch (getCategory()) {
            case CATEGORY_DOUJINSHI:
                return R.string.category_doujinshi;
            case CATEGORY_MANGA:
                return R.string.category_manga;
            case CATEGORY_ARTISTCG:
                return R.string.category_artistcg;
            case CATEGORY_GAMECG:
                return R.string.category_gamecg;
            case CATEGORY_WESTERN:
                return R.string.category_western;
            case CATEGORY_NON_H:
                return R.string.category_non_h;
            case CATEGORY_IMAGESET:
                return R.string.category_imageset;
            case CATEGORY_COSPLAY:
                return R.string.category_cosplay;
            case CATEGORY_ASIANPORN:
                return R.string.category_asianporn;
            default:
                return R.string.category_misc;
        }
    }

    public int getCategoryColor(){
        switch (getCategory()) {
            case CATEGORY_DOUJINSHI:
                return R.color.category_doujinshi;
            case CATEGORY_MANGA:
                return R.color.category_manga;
            case CATEGORY_ARTISTCG:
                return R.color.category_artistcg;
            case CATEGORY_GAMECG:
                return R.color.category_gamecg;
            case CATEGORY_WESTERN:
                return R.color.category_western;
            case CATEGORY_NON_H:
                return R.color.category_non_h;
            case CATEGORY_IMAGESET:
                return R.color.category_imageset;
            case CATEGORY_COSPLAY:
                return R.color.category_cosplay;
            case CATEGORY_ASIANPORN:
                return R.color.category_asianporn;
            default:
                return R.color.category_misc;
        }
    }

    public void fromJSON(JSONObject data) throws JSONException {
        setId(Long.parseLong(data.getString("gid")));
        setToken(data.getString("token"));
        setTitle(data.getString("title"));
        setSubtitle(data.getString("title_jpn"));
        setCategory(data.getString("category"));
        setThumbnail(data.getString("thumb"));
        setCount(data.getInt("filecount"));
        setRating((float) data.getDouble("rating"));
        setUploader(data.getString("uploader"));
        setCreated(new Date(data.getLong("posted") * 1000));
        setSize(Long.parseLong(data.getString("filesize")));
        setTags(data.getJSONArray("tags").toString());
    }
}