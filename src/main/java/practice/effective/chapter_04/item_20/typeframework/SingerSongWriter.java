package practice.effective.chapter_04.item_20.typeframework;

public interface SingerSongWriter extends Singer, SongWriter {

  AudioClip strum();

  void actSensitive();

}
