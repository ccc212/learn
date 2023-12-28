package src.thread;

import src.Info;
import src.Logic;
import src.Player;
import src.UI.ChessBoard;
import src.UI.ChessPiece;
import src.UI.Game;

import java.awt.*;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class InRunnable implements Runnable {
    private Socket socket;
    private ObjectInputStream ois;

    public InRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            while (true) {
//                synchronized (Game.instance.getLock()) {
                    try {
                        ois = new ObjectInputStream(socket.getInputStream());

                        Info info = (Info) ois.readObject();

                        if (info.getPoint() != null && Game.getChessBoard().judge(info.getPoint().x, info.getPoint().y) == true) {
                            Game.getChessBoard().click(info.getPoint().x, info.getPoint().y);
                        }

                        if (info.getString() != null) {
                            if (info.getString().equals("对方已离开")) {
//                            Logic.leave(Game.instance.getChessBoard(), Player.isRoomOwner());
//                            break;
                            } else if (info.getString().equals("R")) {
//                                if (Logic.back(Game.instance.getChessBoard().board,
//                                        Game.instance.getChessBoard().stack,
//                                        Game.instance.getChessBoard().map)){
//                                    System.out.println("悔棋");
//                                    ChessBoard.player = !ChessBoard.player;
//                                    Game.instance.getChessBoard().updateUI();
//                                }
                            }
                        }

                    } catch (Exception e) {
//                System.out.println("有异常");
                        continue;
                    }
//                    Game.instance.getLock().notify();
//                }

                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
