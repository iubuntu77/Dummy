package musiclib.audio;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileFilter;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.apache.commons.io.FileUtils.iterateFiles;

/**
 * Created by priyanshu on 4/3/14.
 */
public class AudioMetaProcessor {

    public static void main(String[] args) {

        readMetaDate();

    }

    public static void readMetaDate() {
        AudioFile f;

        try {

            String[] formats = null ;// {"mp3", "mp4", "wma"};

            //   fd = new FileUtils("/Users/priyanshu/Music/iTunes/iTunes Media/Music/");
            File fd = new File("/Users/priyanshu/Music/iTunes/iTunes Media/Music/");
            Iterator<File> fi = iterateFiles(fd, formats, true);

            Set<String> ft = new HashSet<String>();
            int c = 0,s=0;

            AudioFileFilter af = new AudioFileFilter(true);
            File t;
            while (fi.hasNext()) {
                t = fi.next();
                if (af.accept(t)) {
                    ++c;
                    f = AudioFileIO.read(t);
                    ft.add(f.getAudioHeader().getFormat());

                }
            }

            System.out.println(" file count " + c + " non-mp3 files " + s);

            System.out.println("music formats  " + ft.size() + " " + ft.toString());

           /*  if (fd.isDirectory()) for (File fx : fd.listFiles()) {

                f = AudioFileIO.read(fx);
                System.out.println(f.getAudioHeader().getFormat());


                MP3File m = (MP3File) f;
                System.out.println(m.hasID3v2Tag());
                if(m.hasID3v2Tag())
                {
                    AbstractID3v2Tag v2 = m.getID3v2TagAsv24();
                    System.out.println("artist :" + v2.getFirst(FieldKey.ARTIST));
                    System.out.println("album " + v2.getFirst(FieldKey.ALBUM));
                    System.out.println("title " + v2.getFirst(FieldKey.TITLE));
                    System.out.println("comment " + v2.getFirst(FieldKey.COMMENT));
                    System.out.println("year " + v2.getFirst(FieldKey.YEAR));
                    System.out.println("track " + v2.getFirst(FieldKey.TRACK));
                    System.out.println("disc_no " + v2.getFirst(FieldKey.DISC_NO));
                    System.out.println("composer " + v2.getFirst(FieldKey.COMPOSER));
                    System.out.println("artist_sort " + v2.getFirst(FieldKey.ARTIST_SORT));
                }
               Tag tag = f.getTag();
                System.out.println("artist :" + tag.getFirst(FieldKey.ARTIST));
                System.out.println("album " + tag.getFirst(FieldKey.ALBUM));
                System.out.println("title " + tag.getFirst(FieldKey.TITLE));
                System.out.println("comment " + tag.getFirst(FieldKey.COMMENT));
                System.out.println("year " + tag.getFirst(FieldKey.YEAR));
                System.out.println("track " + tag.getFirst(FieldKey.TRACK));
                System.out.println("disc_no " + tag.getFirst(FieldKey.DISC_NO));
                System.out.println("composer " + tag.getFirst(FieldKey.COMPOSER));
                System.out.println("artist_sort " + tag.getFirst(FieldKey.ARTIST_SORT));


            } */
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
    }


}
