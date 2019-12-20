package FullTime.Amazon.OA;

import java.util.*;

public class FavoriteGenres {

    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, String> songToGenre = new HashMap<>();
        if (songGenres != null) {
            for (String genre: songGenres.keySet()) {
                for (String song: songGenres.get(genre)) {
                    songToGenre.put(song, genre);
                }
            }
        }

        Map<String, List<String>> res = new HashMap<>();
        if (userSongs != null) {
            for (String user: userSongs.keySet()) {
                List<String> genres = getGenres(userSongs.get(user), songToGenre);
                res.put(user, genres);
            }
        }
        return res;
    }

    // given a user's song list, return a list of his/her favorite genres
    public List<String> getGenres(List<String> songs, Map<String, String> songToGenre) {
        int max = 0;
        List<String> list = new ArrayList<>();
        Map<String, Integer> genreCount = new HashMap<>();

        for (String song: songs) {
            if (!songToGenre.containsKey(song)) continue;
            String genre = songToGenre.get(song);
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
            if (genreCount.get(genre) > max) {
                max = genreCount.get(genre);
            }
        }

        if (max == 0) return new ArrayList<>();
        for (String genre: genreCount.keySet()) {
            if (genreCount.get(genre) == max) {
                list.add(genre);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> res = new FavoriteGenres().favoriteGenres(userSongs, songGenres);
        for (String s: res.keySet()) {
            List<String> list = res.get(s);
            System.out.println(s);
            for (String genre: list) {
                System.out.print(genre + " ");
            }
            System.out.println();
        }
    }
}
