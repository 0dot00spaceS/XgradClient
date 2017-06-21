package Controllers;

import Storage.ElementXpath;
import View.MainWindows.Controller;
import netscape.javascript.JSObject;
import org.w3c.dom.NodeList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Console{
    private Scanner sc = new Scanner(System.in);
    enum com{
        ATTACKED_TRUE,
        OPEN_MAP,
        BTN_SIGN_IN,
        EXIT,
        ALERT,
        DOCUMENT,
        TEST_TEXT,
        CONTINUE
    }

    public Controller controller;

    private String comToString(com _com){
        switch (_com){
            case EXIT: return "EXIT";
            case ATTACKED_TRUE: return "ATTACKED_TRUE";
            case OPEN_MAP: return "OPEN_MAP";
            case BTN_SIGN_IN: return "BTN_SIGN_IN";
            case ALERT: return "ALERT";
            case DOCUMENT: return "DOCUMENT";
            case TEST_TEXT: return "TEST_TEXT";
        }
        return "CONTINUE";
    }

    private com stringToCom(String str){
        if (str.equals(comToString(com.EXIT))){
            return com.EXIT;
        }
        if (str.equals(comToString(com.ATTACKED_TRUE))){
            return com.ATTACKED_TRUE;
               }
        if (str.equals(comToString(com.OPEN_MAP))){
            return com.OPEN_MAP;
        }
        if (str.equals(comToString(com.BTN_SIGN_IN))){
            return com.BTN_SIGN_IN;
        }
        if (str.equals(comToString(com.ALERT))){
            return com.ALERT;
        }
        if (str.equals(comToString(com.DOCUMENT))){
            return com.DOCUMENT;
        }
        if (str.equals(comToString(com.TEST_TEXT))){
            return com.TEST_TEXT;
        }
        return com.CONTINUE;
    }

    public String getCommand(){
        return sc.nextLine();
    }


    public void Select(String buffer ) {
        if (buffer==null)
            return;
        switch (stringToCom(buffer)) {
            case CONTINUE:
                break;
            case EXIT:
                exit(0);
                break;
            case ATTACKED_TRUE:
                Attack.loop();
                break;
            case OPEN_MAP:
            /*/    NodeList list = controller.getNodeList(ElementXpath.x_paths.OPEN_MAP);
                JSObject element = (JSObject) list.item(0);
                if (element != null) {
                    element.call("submit");
                    //TimeUnit.SECONDS.sleep(randomTime(_min_time, _max_time));
                }*/
                break;
            case BTN_SIGN_IN:
                System.out.print("\t"+controller.runScript(JSBuild.clickElement(ElementXpath.getXPath(ElementXpath.x_paths.BTN_SIGN_IN), 0))+ "\n\n");
                break;
            case ALERT:
                controller.runScript(JSBuild.alert());
                break;
            case DOCUMENT:
                System.out.print("\t"+controller.runScript(JSBuild.getDocument())+"\n\n");
                break;
            case TEST_TEXT:
                System.out.print("\t"+controller.runScript(JSBuild.testGetText("Hello!!"))+"\n\n");
                break;
        }
    }
}
