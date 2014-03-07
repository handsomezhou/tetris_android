package com.example.tetris.object;

public class GameConfig {
	/* 定义俄罗斯方块7种方块类型 */
	public enum BlockType {
		BLOCK_I, BLOCK_J, BLOCK_L, BLOCK_O, BLOCK_S, BLOCK_Z, BLOCK_T, /* BLOCK_TYPE_NUM */
	}

	/* 俄罗斯方块中方块总类型数目 */
	public static final int BLOCK_TYPE_NUM = 7;
	/* 俄罗斯方块每个方块长和宽 */
	//public static final int BLOCK_WIDTH = 4;
	//public static final int BLOCK_HEIGHT = 4;
	/* 俄罗斯方块每个方块的具体数目 */
	public static final int BLOCK_I_NUM = 2;
	public static final int BLOCK_J_NUM = 4;
	public static final int BLOCK_L_NUM = 4;
	public static final int BLOCK_O_NUM = 1;
	public static final int BLOCK_S_NUM = 2;
	public static final int BLOCK_Z_NUM = 2;
	public static final int BLOCK_T_NUM = 4;
	public static final int BLOCK_SINGLE_MAX_NUM = 4;

	/* 俄罗斯方块中方块总数目 */
	public static final int BLOCK_TOTAL_NUM = 19; /*
													 * BLOCK_I_NUM+...+BLOCK_T_NUM
													 */
	/* 将俄罗斯方块中方块编号:BLOCK_X_START_NUM~BLOCK_X_NUM-1 代表X类型的方块所属编号 */
	public static final int BLOCK_I_START_NUM = 0;
	public static final int BLOCK_J_START_NUM = (BLOCK_I_START_NUM + BLOCK_I_NUM);
	public static final int BLOCK_L_START_NUM = (BLOCK_J_START_NUM + BLOCK_J_NUM);
	public static final int BLOCK_O_START_NUM = (BLOCK_L_START_NUM + BLOCK_L_NUM);
	public static final int BLOCK_S_START_NUM = (BLOCK_O_START_NUM + BLOCK_O_NUM);
	public static final int BLOCK_Z_START_NUM = (BLOCK_S_START_NUM + BLOCK_S_NUM);
	public static final int BLOCK_T_START_NUM = (BLOCK_Z_START_NUM + BLOCK_Z_NUM);
}
