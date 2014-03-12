package com.example.tetris.object;

import com.example.tetris.object.GameConfig.BlockType;

public class Grid {
	private int indexY; /* ��С����Grid[y][x]������ y */
	private int indexX; /* ��С����Grid[y][x]������ x */
	private BlockType blockType; /* ������������ */
	private char value; /* '1'or '0','1'��ʾ��λ����С����,'0'��ʾ��λ����С���� */

	// ����Block�е�С���������������е�λ��
	public Grid(int indexY, int indexX) {
		this.indexY = indexY;
		this.indexX = indexX;
	}

	public void setIndexYX(int indexY, int indexX) {
		this.indexY = indexY;
		this.indexX = indexX;
	}

	public int getIndexY() {
		return this.indexY;
	}

	public int getIndexX() {
		return this.indexX;
	}

	public void setBlockType(BlockType blockType) {
		this.blockType = blockType;
	}

	public BlockType getBlockType() {
		return this.blockType;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public char getValue() {
		return this.value;
	}
}