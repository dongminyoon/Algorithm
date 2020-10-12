package Hash;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] plays = {400, 600, 150, 2500, 500, 500};

        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> gernePlayCount = new HashMap<>();
        HashMap<String, ArrayList<Music>> gerneMusics = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (gernePlayCount.containsKey(genres[i])) {
                gerneMusics.get(genres[i]).add(new Music(i, plays[i], genres[i]));
                gernePlayCount.put(genres[i], gernePlayCount.get(genres[i]) + plays[i]);
            } else {
                gerneMusics.put(genres[i], new ArrayList<>());
                gerneMusics.get(genres[i]).add(new Music(i, plays[i], genres[i]));
                gernePlayCount.put(genres[i], plays[i]);
            }
        }

        // 장르 별 카운트를 기준으로 Sorting
        List<Map.Entry<String, Integer>> sortingByValue = new ArrayList<>(gernePlayCount.entrySet());
        Collections.sort(sortingByValue, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 장르 별 음악의 플레이 카운트를 기준으로 Sorting
        for (String key : gerneMusics.keySet()) {
            Collections.sort(gerneMusics.get(key), (o1, o2) -> {
                if (o1.playCount == o2.playCount) {
                    return o1.i.compareTo(o2.i);
                }
                return o2.playCount.compareTo(o1.playCount);
            });
        }

        int index = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (index != sortingByValue.size()) {
            String curKey = sortingByValue.get(index).getKey();
            ArrayList<Music> musics = gerneMusics.get(curKey);
            int count = 0;

            if (musics.size() == 1) {
                result.add(musics.get(0).i);
                index++;
                continue;
            }

            for (int i = 0; i < musics.size(); i++) {
                count++;

                if (count == 2) {
                    result.add(musics.get(i-1).i);
                    result.add(musics.get(i).i);
                    break;
                }
            }

            index++;
        }


        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }
}

class Music {
    Integer i, playCount;
    String genre;

    Music(int i, int playCount, String genre) {
        this.i = i;
        this.playCount = playCount;
        this.genre = genre;
    }
}
