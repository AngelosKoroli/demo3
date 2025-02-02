package com.example.demo3;

import com.example.CommunicationData;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.Socket;

public class MyClientController extends ClientServerController{
    public TextField From;
    public TextField To;
    public TextField messageTyped;
    Numbers queue;
    ClientConnection serverConnection;

    public void initialize() throws Exception {
        IPColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("fromIPAddress"));
        fromColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("from"));
        toColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("to"));
        messageColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("message"));

        System.out.println("Connecting to my server");
        Socket newSocket = new Socket("10.37.153.155",3256);
        queue = new Numbers();
        serverConnection = new ClientConnection(newSocket);
        DataReader myDataReader = new DataReader(serverConnection, queue);
        ProgramLogicDoer myProgramLogicDoer = new ProgramLogicDoer(queue, this, false);
        Thread dataReadThread = new Thread(myDataReader);
        Thread programLogicThread = new Thread(myProgramLogicDoer);
        dataReadThread.start();
        programLogicThread.start();

        CommunicationData identity = new CommunicationData("Angelos","SERVER","ID", 0);
        serverConnection.getObjOut().writeObject(identity);
        System.out.println("ClientController initialize() wrote: " + identity);
    }

    public void sendMessage() throws Exception {
        CommunicationData data1 = new CommunicationData(From.getText(), To.getText(), messageTyped.getText(), 0);
        serverConnection.getObjOut().writeObject(data1);
        System.out.println("ClientController sendMessage() wrote: " + data1);
    }

}
