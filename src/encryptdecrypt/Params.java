package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Params{
    private Mode mode;
    private Algorithm algorithm;
    private File in;
    private File out ;
    private int key ;
    private String data;

    public Params(Mode mode, Algorithm algorithm, int key, String data, String[] args) {
        this(mode, algorithm, key, data);
        for (int i = 0; i < args.length - 1; i++){
            switch (args[i]) {
                case "-mode":
                    this.setMode(args[++i]);
                    break;
                case "-key":
                    this.setKey(args[++i]);
                    break;
                case "-data":
                    this.setData(args[++i]);
                    break;
                case "-in":
                    this.setIn(args[++i]);
                    break;
                case "-out":
                    this.setOut(args[++i]);
                    break;
                case "-alg":
                    this.setAlgorithm(args[++i]);
                    break;
            }
        }
    }

    public Params(Mode mode, Algorithm algorithm, int key, String data) {
        this.mode = mode;
        this.algorithm = algorithm;
        this.key = key;
        this.data = data;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = Mode.valueOf(mode.toUpperCase());
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = Algorithm.valueOf(algorithm.toUpperCase());
    }

    public File getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = new File(in);
        if(this.getIn() != null)
        {
            try (Scanner scanIn = new Scanner(this.getIn())){
                this.setData(scanIn.nextLine());
            } catch (Exception e){
                System.out.println("Exception: File" + this.getIn() + "not found. data = " + this.getData());
            }
        }
    }

    public File getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = new File(out);
    }

    public int getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Integer.parseInt(key);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    boolean writeToFile(String str){
        try  (FileWriter writer = new FileWriter(this.out, false)){
            writer.write("");
        } catch (Exception e){
            return false;
        }
        try  (FileWriter writer = new FileWriter(this.out, true)){
            writer.write(str + "\r\n");
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
