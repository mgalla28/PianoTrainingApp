package uic.cs.marvin.musictrainingsim;

public class Options
{
    private static boolean fullscreen = false;

    private Options()
    { }

    public static boolean isFullscreen()
    {
        return fullscreen;
    }

    public static boolean toggleFullscreen()
    {
        fullscreen = !fullscreen;
        return fullscreen;
    }
}
