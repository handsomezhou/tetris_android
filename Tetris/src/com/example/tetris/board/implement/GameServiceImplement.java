package com.example.tetris.board.implement;

import android.widget.Toast;

import com.example.tetris.Tetris;
import com.example.tetris.board.GameService;
import com.example.tetris.object.Block;
import com.example.tetris.object.GameConfig;
import com.example.tetris.object.Grid;

public class GameServiceImplement implements GameService {

	/* ����һ��Grid���鱣����Ϸ����ķ�����Ϣ */
	private Grid[][] board = null;

	/* ��Ϸ���ö��� */
	private GameConfig gameConfig = null;

	public GameServiceImplement(GameConfig gameConfig) {
		// TODO Auto-generated constructor stub
		this.gameConfig = gameConfig;
		this.board = init_board(this.gameConfig);
	};

	private Grid[][] init_board(GameConfig gameConfig) {
		Grid[][] board = new Grid[gameConfig.getYSize()][gameConfig
				.getXSize()];
		for (int y = 0; y < gameConfig.getYSize(); y++) {
			for (int x = 0; x < gameConfig.getXSize(); x++) {
				Grid block = new Grid(y, x);
				
				board[y][x] = block;
			}
		}
		return board;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Toast.makeText(gameConfig.getContext(), "I'm pauseContinueButton!",
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void set_level(int level) {
		// TODO Auto-generated method stub
		Toast.makeText(gameConfig.getContext(), "I'm levelIncreasesButton!",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public Block move_left_block() {
		// TODO Auto-generated method stub
		Toast.makeText(gameConfig.getContext(), "I'm leftButton!",
				Toast.LENGTH_SHORT).show();

		return null;
	}

	@Override
	public Block move_right_block() {
		// TODO Auto-generated method stub
		Toast.makeText(gameConfig.getContext(), "I'm rightButton!",
				Toast.LENGTH_SHORT).show();
		return null;
	}

	@Override
	public Block fast_down_block() {
		// TODO Auto-generated method stub
		Toast.makeText(gameConfig.getContext(), "I'm downButton!",
				Toast.LENGTH_SHORT).show();
		return null;
	}

	@Override
	public Block rotate_block() {
		// TODO Auto-generated method stub

		Toast.makeText(gameConfig.getContext(), "I'm upButton!",
				Toast.LENGTH_SHORT).show();
		return null;
	}

	@Override
	public Grid[][] getGrid() {
		// TODO Auto-generated method stub
		return this.board;
	}

	@Override
	public GameConfig getGameConfig() {
			return this.gameConfig;
	}
}