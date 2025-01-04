package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GhostDataProvider {

//    @DataProvider(name = "JSON_Data_Provider")
//    public Object[] jsonDataProvider(){
//        JsonParser jsonParser = new JsonParser();
//        FileReader jsonFileReader = new FileReader("test-data/testDataUser.json");
//
//    }

    @Test
    public void jsonDataReader() throws FileNotFoundException {
        //Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        FileReader jsonFileReader = new FileReader("test-data/testDataUser.json");
        Object obj = jsonParser.parse(jsonFileReader);
        JsonObject userloginsJsonobj=(JsonObject)obj;
        JsonArray userloginsArray=(JsonArray)userloginsJsonobj.get("userlogins");
        String arr[]=new String[userloginsArray.size()];
        for (int i=0; i<userloginsArray.size();i++)
        {
            JsonObject users=(JsonObject) userloginsArray.get(i);
            String user= String.valueOf(users.get("username"));
            String pwd= String.valueOf(users.get("password"));
            arr[i]=user+"," +pwd ;
            System.out.println("user / password: " +user+"," +pwd);
        }

    }


    public class myJson {
        public String name;
        public int id;
        public String title;
        public String body;
    }

}


