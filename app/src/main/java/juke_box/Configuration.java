package juke_box;

import juke_box.repositories.IPlaylistRepository;
import juke_box.repositories.ISongRepository;
import juke_box.repositories.PlaylistRepository;
import juke_box.repositories.SongRepository;
import juke_box.services.PlaylistService;
import juke_box.services.SongService;

public class Configuration {
    // private static Configuration instance = new Configuration();

    // private Configuration() {}

    // public static Configuration getInstance() {
    //     return instance;
    // }

    // // Initialize repositories

    // private final IPlaylistRepository playlistRepository = new PlaylistRepository();
    // private final ISongRepository songRepository = new SongRepository();

    // // Initialize services

    // private final PlaylistService playlistService = new PlaylistService(songRepository, playlistRepository);
    // private final SongService songService = new SongService(songRepository);

    // // Initialize commands
    // // private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
    // // private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
    // // private final GetGreetingCommand getGreetingCommand = new GetGreetingCommand(greetingService);
    // private final AddSongCommand addSongCommand = new AddSongCommand(songService);
    // private final AddSongToPlaylistCommand addSongToPlaylistCommand = new AddSongToPlaylistCommand(playlistService, songService);
    // private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
    // private final CreateSongCommand createSongCommand = new CreateSongCommand(songService);
    // private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
    // private final DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand = new DeleteSongFromPlaylistCommand(playlistService, songService);
    // private final GetSongCommand getSongCommand = new GetSongCommand(songService);
    // private final ListPlaylistsCommand listPlaylistsCommand = new ListPlaylistsCommand(playlistService);
    // private final ListSongsCommand listSongsCommand = new ListSongsCommand(songService);
    // private final LoadPlaylistCommand loadPlaylistCommand = new LoadPlaylistCommand(playlistService);
    // private final NextSongCommand nextSongCommand = new NextSongCommand(songService);
    // private final PlaySongCommand playSongCommand = new PlaySongCommand(songService);
    // private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(songService);
    // private final StopSongCommand stopSongCommand = new StopSongCommand(songService);

    // // Initialize CommandRegistry
    // private final CommandRegistry commandRegistry = new CommandRegistry(songService, playlistService);

    // private void registerCommands() {
    //     commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(), createGreetingCommand);
    //     commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(), listGreetingCommand);
    //     commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(), getGreetingCommand);
    //     commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(), addSongCommand);
    //     commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(), addSongToPlaylistCommand);
    //     commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(), createPlaylistCommand);
    //     commandRegistry.registerCommand(CommandKeyword.CREATE_SONG_COMMAND.getName(), createSongCommand);
    //     commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(), deletePlaylistCommand);
    //     commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(), deleteSongFromPlaylistCommand);
    //     commandRegistry.registerCommand(CommandKeyword.GET_SONG_COMMAND.getName(), getSongCommand);
    //     commandRegistry.registerCommand(CommandKeyword.LIST_PLAYLISTS_COMMAND.getName(), listPlaylistsCommand);
    //     commandRegistry.registerCommand(CommandKeyword.LIST_SONGS_COMMAND.getName(), listSongsCommand);
    //     commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(), loadPlaylistCommand);
    //     commandRegistry.registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(), nextSongCommand);
    //     commandRegistry.registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(), playSongCommand);
    //     commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(), previousSongCommand);
    //     commandRegistry.registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(), stopSongCommand);
    // }

    // public CommandRegistry getCommandRegistry() {
    //     registerCommands();
    //     return commandRegistry;
    // }
    
}
