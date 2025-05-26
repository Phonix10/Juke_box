package juke_box.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import juke_box.services.PlaylistService;
import juke_box.services.SongService;

public class CommandRegistry {
    private final Map<String, ICommand> commands = new HashMap<>();

    public CommandRegistry(SongService songService, PlaylistService playlistService) {
        // Register commands with their respective services
        registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(), new AddSongCommand(songService));
        registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(), new AddSongToPlaylistCommand(playlistService, songService));
        registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(), new CreatePlaylistCommand(playlistService));
        registerCommand(CommandKeyword.CREATE_SONG_COMMAND.getName(), new CreateSongCommand(songService));
        registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(), new DeletePlaylistCommand(playlistService));
        registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(), new DeleteSongFromPlaylistCommand(playlistService, songService));
        registerCommand(CommandKeyword.GET_SONG_COMMAND.getName(), new GetSongCommand(songService));
        registerCommand(CommandKeyword.LIST_PLAYLISTS_COMMAND.getName(), new ListPlaylistsCommand(playlistService));
        registerCommand(CommandKeyword.LIST_SONGS_COMMAND.getName(), new ListSongsCommand(songService));
        registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(), new LoadPlaylistCommand(playlistService));
        registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(), new NextSongCommand(songService));
        registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(), new PlaySongCommand(songService));
        registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(), new PreviousSongCommand(songService));
        registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(), new StopSongCommand(songService));
    
    }

    public void registerCommand(String commandKeyword, ICommand command) {
        commands.putIfAbsent(commandKeyword, command);
    }

    public void unregisterCommand(String commandKeyword) {
        commands.remove(commandKeyword);
    }

    private ICommand get(String commandName) {
        return commands.get(commandName);
    }

    private List<String> parse(String input) {
        return Arrays.stream(input.split(" "))
                     .filter(token -> !token.isEmpty())
                     .collect(Collectors.toList());
    }

    public String invokeCommand(String input) {
        List<String> tokens = parse(input);
        if (tokens.isEmpty()) {
            throw new RuntimeException("No command provided.");
        }
        ICommand command = get(tokens.get(0));
        if (command == null) {
            throw new RuntimeException("INVALID COMMAND 🛑");
        }

        try {
            command.invoke(tokens);
        } catch (Exception e) {
            throw new RuntimeException("Error executing command: " + e.getMessage(), e);
        }
        return input;
    }
}










