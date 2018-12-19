package informatika.machung.jadual.mahasiswa.listEvent;

import java.util.ArrayList;

public class DataEvent {

        public static String[][] data = new String[][]{
                {
                    "00.00 - 24.00",
                    "Meeting",
                    "kalau butuh bisa chat"
                },

                {
                    "00.00 - 24.00",
                    "SemHas",
                    ""
                },

                {
                    "00.00 - 24.00",
                    "Sempro",
                    "jangan diganggu"
                },

                {
                    "00.00 - 24.00",
                    "Forkomil",
                    ""
                },

                {
                    "00.00 - 24.00",
                    "Kelas Algoritma",
                    "biaa hubungi melalui chat line"
                }

        };

        public static ArrayList<Event> getListData(){
            Event event = null;
            ArrayList<Event> list = new ArrayList<>();
            for (int i = 0; i <data.length; i++) {
                event = new Event();
                event.setEvent_time(data[i][0]);
                event.setEvent_name(data[i][1]);
                event.setEvent_desc(data[i][2]);

                list.add(event);
            }

            return list;
        }
}
