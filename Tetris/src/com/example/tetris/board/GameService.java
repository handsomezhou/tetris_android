package com.example.tetris.board;

import com.example.tetris.view.Block;

public interface GameService {
	// Block [][]board=null;
	/*
	 * 游戏开始
	 */
	void start();

	/*
	 * 游戏暂停
	 */
	void pause();

	/*
	 * 等级设置
	 */
	void set_level(int level);

	/*
	 * 方块左移
	 */
	Block move_left_block();

	/*
	 * 方块右移
	 */
	Block move_right_block();

	/*
	 * 方块快速下落
	 */
	Block fast_down_block();

	/*
	 * 方块翻转
	 */
	Block rotate_block();

	/*
	 * 获取方块数组
	 */
	Block[][] getBlocks();
}
