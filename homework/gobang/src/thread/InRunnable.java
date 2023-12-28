package src.thread;

import src.Info;
import src.Logic;
import src.Player;
import src.UI.ChessBoard;
import src.UI.Game;
import src.UI.Result;
import src.UI.Status;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class InRunnable implements Runnable {
    private final Socket socket;
    private ObjectInputStream ois;

    public InRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            label:
            while (true) {
                    try {
                        ois = new ObjectInputStream(socket.getInputStream());

                        Info info = (Info) ois.readObject();

                        if (info.getPoint() != null && Game.instance.getChessBoard().judge(info.getPoint().x, info.getPoint().y)) {
                            Game.instance.getChessBoard().click(info.getPoint().x, info.getPoint().y);
                        }

                        if (info.getString() != null) {
                            switch (info.getString()) {
                                case "对方已离开":
                                    Logic.leave(Game.instance.getChessBoard(), Player.isRoomOwner());
                                    break label;
                                case "R":
                                    if (Logic.back(Game.instance.getChessBoard().board,
                                            Game.instance.getChessBoard().stack,
                                            Game.instance.getChessBoard().map)) {
                                        int result = JOptionPane.showConfirmDialog(null, "对方申请悔棋", "同意", JOptionPane.YES_NO_OPTION);
                                        if (result == JOptionPane.YES_OPTION) {
                                            Game.instance.setChessBoardClickable(!Game.instance.getChessBoard().getClickable());
                                            System.out.println("悔棋");
                                            ChessBoard.player = !ChessBoard.player;
                                            Game.instance.getChessBoard().updateUI();
                                            OutRunnable.oos.writeObject(new Info("OK"));
                                        }
                                    }
                                    break;
                                case "OK":
                                    if (Logic.back(Game.instance.getChessBoard().board, Game.instance.getChessBoard().stack, Game.instance.getChessBoard().map)) {
                                        ChessBoard.player = !ChessBoard.player;
                                        Game.instance.getChessBoard().updateUI();
                                    }
                                    break;
                            }
                        }

                        if (info.getClickEnable()){
                            Game.instance.setChessBoardClickable(true);
                        }

                    } catch (SocketException e) {
                        new Result(null,Game.instance.getChessBoard(),Status.CLOSE);
                        break;
                    }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
