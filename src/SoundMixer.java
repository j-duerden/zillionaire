/*
 * Who Wants to be a Zillionaire? - Sound Mixer
 * Class that handles the sounds heard within the game
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundMixer 
{
	public void playSound(String sound)
	{
		try
		{
			File soundFile = new File("src/sounds/" + sound + ".wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			clip.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void loopSound(String sound, int duration)
	{
		try
		{
			File soundFile = new File("src/sounds/" + sound + ".wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			clip.loop(duration);
			clip.stop();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void questionLoop(String end, int duration)
	{
		try
		{
			File soundFile = new File("src/sounds/anticipation.wav");
			File soundEnd = new File("src/sounds/" + end +  ".wav");
			Clip clip = AudioSystem.getClip();
			Clip clip2 = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			clip2.open(AudioSystem.getAudioInputStream(soundEnd));
			clip.loop(duration);
			try 
			{
				 Thread.sleep(3000);
			} 
			catch (InterruptedException ie) 
			{
				//Handle exception
			}
			clip.stop();
			clip2.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void questionLoopHard(String end, int duration)
	{
		try
		{
			File soundFile = new File("src/sounds/anticipation.wav");
			File soundEnd = new File("src/sounds/" + end +  ".wav");
			Clip clip = AudioSystem.getClip();
			Clip clip2 = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			clip2.open(AudioSystem.getAudioInputStream(soundEnd));
			clip.loop(duration);
			try 
			{
				 Thread.sleep(3000);
			} 
			catch (InterruptedException ie) 
			{
				//Handle exception
			}
			clip.stop();
			clip2.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
