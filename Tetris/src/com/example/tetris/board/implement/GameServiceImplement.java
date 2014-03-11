package com.example.tetris.board.implement;

import android.widget.Toast;

import com.example.tetris.Tetris;
import com.example.tetris.board.GameService;
import com.example.tetris.object.GameConfig;
import com.example.tetris.view.Block;

public class GameServiceImplement implements GameService {

	/* 定义一个Block数组保存游戏区域的方块信息 */
	private Block[][] board = null;

	/* 游戏配置对象 */
	private GameConfig gameConfig = null;

	public GameServiceImplement(GameConfig gameConfig) {
		// TODO Auto-generated constructor stub
		this.gameConfig = gameConfig;
		this.board = init_board(this.gameConfig);
	};

	private Block[][] init_board(GameConfig gameConfig) {
		Block[][] board = new Block[gameConfig.getYSize()][gameConfig
				.getXSize()];
		for (int y = 0; y < gameConfig.getYSize(); y++) {
			for (int x = 0; x < gameConfig.getXSize(); x++) {
				Block block = new Block(y, x);
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
	public Block[][] getBlocks() {
		// TODO Auto-generated method stub
		return this.board;
	}

	public GameConfig getGameConfig() {
		return this.gameConfig;
	}

}
