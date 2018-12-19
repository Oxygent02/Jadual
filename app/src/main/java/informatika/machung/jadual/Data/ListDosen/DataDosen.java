package informatika.machung.jadual.Data.ListDosen;

import java.util.ArrayList;

public class DataDosen {

        public static String[][] data = new String[][]{
                {
                    "Dr.Eng. Romy Budhi Widodo",
                    "Not Available",
                    "android.resource://informatika.machung.jadual/drawable/dosen_romy",
                    "Saya Romi"
                },

                {
                    "Hendry Setiawan, ST., M.Kom",
                    "Available in room",
                    "android.resource://informatika.machung.jadual/drawable/dosen_hendry",
                    "Hi Aku Hendry"
                },

                {
                    "Ir. Oesman Hendra Kelana, M.Div., M.Cs",
                    "Not Available",
                    "android.resource://informatika.machung.jadual/drawable/dosen_oesman",
                    "Saya Usman hehehe"
                },

                {
                    "Kestrilia Rega Prilianti, M.Si",
                    "Break",
                    "android.resource://informatika.machung.jadual/drawable/dosen_kestrillia",
                    "Aku adalah Ibu Lia"
                },

                {
                    "Mochamad Subianto, S.Kom., M.Cs",
                    "Available in Room",
                    "android.resource://informatika.machung.jadual/drawable/dosen_subi",
                    "Nama saya adalah Subi"
                },

                {
                    "Paulus Lucky Tirma Irawan, S.Kom., MT",
                    "Available in Room",
                    "android.resource://informatika.machung.jadual/drawable/dosen_paulus",
                    "Perkenalkan saya Lucky"
                },


                {
                    "Windra Swastika, Ph.D",
                    "Available in Room",
                    "android.resource://informatika.machung.jadual/drawable/dosen_windra",
                    "Saya Windra"
                }

        };

        public static ArrayList<DosenModel> getListData(){
            DosenModel dosenModel = null;
            ArrayList<DosenModel> list = new ArrayList<>();
            for (int i = 0; i <data.length; i++) {
                dosenModel = new DosenModel();
                dosenModel.setName(data[i][0]);
                dosenModel.setRemarks(data[i][1]);
                dosenModel.setPhoto(data[i][2]);
                dosenModel.setDescription(data[i][3]);

                list.add(dosenModel);
            }

            return list;
        }
}
