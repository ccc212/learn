package src.thread;

import src.Info;
import src.Logic;
import src.Player;
import src.UI.Game;

import java.awt.*;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class InRunnable implements Runnable {
    private Socket socket;
    private Game game;
    private Point point;
    private InputStream is;
    private ObjectInputStream ois;

    public InRunnable(Socket socket, Game game){
        this.socket = socket;
        this.game = game;
    }
    @Override
    public void run() {
        try {
            while (true) {
                try {
                    ois = new ObjectInputStream(socket.getInputStream());

                    Info info = (Info) ois.readObject();

                    if(info.getPoint() != null && game.getChessBoard().judge(info.getPoint().x, info.getPoint().y) == true) {
                        game.getChessBoard().click(info.getPoint().x, info.getPoint().y);
                    }

                    if(info.getString() != null) {
                        if(info.getString().equals("对方已离开")) {
//                            Logic.leave(game.getChessBoard(), Player.isRoomOwner());
//                            break;
                        }
                        else if(info.getString().equals("R")) {
                            Logic.back(game.getChessBoard().board,
                                    game.getChessBoard().stack,
                                    game.getChessBoard().map,
                                    game.getChessBoard().row,
                                    game.getChessBoard().column
                            );
                            game.getChessBoard().updateUI();
                        }
                    }

                } catch (Exception e) {
//                System.out.println("有异常");
                    continue;
                }

                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
