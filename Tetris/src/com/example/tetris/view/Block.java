package com.example.tetris.view;

import com.example.tetris.object.GameConfig.BlockType;

/**
 * Description: ����˹�����еķ������
 * 
 * @author ZJQ
 * @Date: 2014-03-7
 * @version 1.0
 */
public class Block {
	public static final int BLOCK_WIDTH = 4;
	public static final int BLOCK_HEIGHT = 4;
	
	private int indexY;		/*�ö�����Block[y][x]������ y*/
	private int indexX;		/*�ö�����Block[y][x]������ x*/
	private BlockType blockType;/*����˹��������*/
	private int	blockNumber;	/*����ı���,��ΧΪ0~BLOCK_X_NUM-1,�����ж���blockType�����¾����ĸ�����*/
	private char []blck=new char[BLOCK_WIDTH*BLOCK_HEIGHT];/*���淽������*/
}