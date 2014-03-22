package com.example.tetris.view;

import com.example.tetris.R;
import com.example.tetris.object.Block;
import com.example.tetris.object.Grid;
import com.example.tetris.service.GameService;
import com.example.tetris.service.GameService.Direction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class GameView extends ImageView implements OnGestureListener,
		OnTouchListener {
	GestureDetector mGestureDetector;
	// 游戏逻辑的实现类
	private GameService gameService = null;
	// //当前方块与下一个方块
	// private Block curBlock=null;
	// private Block nextBlock=null;
	// 俄罗斯方块小方格图片
	private Bitmap[] block_color;
	private Bitmap gameOver;
	private Bitmap gamePause;

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mGestureDetector = new GestureDetector(context, this);
		loadPicture();
		System.out.printf("GameView..................\n");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		float x1 = e1.getX();
		float y1 = e1.getY();
		float x2 = e2.getX();
		float y2 = e2.getY();
		float distance_x = Math.abs(x2 - x1);
		float distance_y = Math.abs(y2 - y1);
		int x_move_steps = 0;
		int y_move_steps = 0;
		Direction direction = getDirection(x1, y1, x2, y2);
		x_move_steps = (int) (Math.abs(distance_x) / gameService
				.getGameConfig().getImageWidth());
		y_move_steps = (int) (Math.abs(distance_y) / gameService
				.getGameConfig().getImageHeight());
		System.out.printf("============(%f,%f)---(%d,%d)\n", distance_y,
				distance_x, gameService.getGameConfig().getImageHeight(),
				gameService.getGameConfig().getImageWidth());
		switch (direction) {
		case DIR_LEFT:
			while (0 < x_move_steps) {
				x_move_steps--;
				if (null == gameService.move_left_block()) {
					x_move_steps = 0;
					Toast.makeText(getContext(),
							"I'm onScroll===DIR_LEFT  null!",
							Toast.LENGTH_SHORT).show();
				}
				this.invalidate();
			}
			// Toast.makeText(getContext(), "I'm onScroll===DIR_LEFT!",
			// Toast.LENGTH_SHORT)
			// .show();
			break;
		case DIR_RIGHT:
			while (0 < x_move_steps) {
				x_move_steps--;
				if (null == gameService.move_right_block()) {
					x_move_steps = 0;
					Toast.makeText(getContext(),
							"I'm onScroll===DIR_RIGHT  null!",
							Toast.LENGTH_SHORT).show();
				}
				this.invalidate();
			}
			// Toast.makeText(getContext(), "I'm onScroll===DIR_RIGHT!",
			// Toast.LENGTH_SHORT)
			// .show();
			break;
		case DIR_DOWN:
			while (0 < y_move_steps) {
				y_move_steps--;
				if (null == gameService.move_down_block()) {
					y_move_steps = 0;
					Toast.makeText(getContext(),
							"I'm onScroll===DIR_DOWN  null!",
							Toast.LENGTH_SHORT).show();
				}
				this.invalidate();
			}
			// Toast.makeText(getContext(), "I'm onScroll===DIR_DOWN!",
			// Toast.LENGTH_SHORT)
			// .show();
			break;
		default:
			Toast.makeText(getContext(), "I'm onScroll===DIR_UP!",
					Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		// Toast.makeText(getContext(), "I'm onDown!",
		// Toast.LENGTH_SHORT).show();
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		Toast.makeText(getContext(), "I'm onLongPress!", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		Toast.makeText(getContext(), "I'm onSingleTapUp!", Toast.LENGTH_SHORT)
				.show();
		gameService.rotate_block();
		this.invalidate();
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		mGestureDetector.onTouchEvent(event);

		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if ((null == this.gameService) || (null == this.block_color))
			return;

		switch (gameService.getGameConfig().getGameStatus()) {
		case STATUS_PLAYING:
			showGameView(canvas);
			break;
		case STATUS_PAUSE:
			showGamePause(canvas);
			break;
		case STATUS_OVER:
			showGameView(canvas);
			showGameOver(canvas);
			break;
		default:
			break;
		}

		this.invalidate();
		System.out.printf("on Draw++++++++++++++++++++++++++++");
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public void setGridColor(Bitmap[] bitbmp) {
		this.block_color = bitbmp;
	}

	private void loadPicture() {
		gameOver = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.game_over);
		gamePause = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.game_pause);
	}

	private Direction getDirection(float startX, float startY, float endX,
			float endY) {
		float distanceX = endX - startX;
		float distanceY = endY - startY;

		if ((distanceX < 0) && (Math.abs(distanceY / distanceX) <= 1)) {
			return Direction.DIR_LEFT;
		} else if ((distanceX > 0) && (Math.abs(distanceY / distanceX) <= 1)) {
			return Direction.DIR_RIGHT;
		} else if (distanceY > 0 && (Math.abs(distanceX / distanceY) < 1)) {
			return Direction.DIR_DOWN;
		} else if ((distanceY < 0) && (Math.abs(distanceX / distanceY) < 1)) {
			return Direction.DIR_UP;
		}

		return Direction.DIR_UP;
	}

	private void showGameView(Canvas canvas) {
		Block curBlock = gameService.getCurBlock();
		Grid[][] board = gameService.getGrid();

		if (null != curBlock) {
			System.out.printf("\ncurBlock======onDraw (y,x)===(%d,%d)\n",
					curBlock.getIndexY(), curBlock.getIndexX());
			for (int i = 0; i < gameService.getGameConfig().getBlockHeight(); i++) {
				for (int j = 0; j < gameService.getGameConfig().getBlockWidth(); j++) {
					if (curBlock.getBlockData()[i
							* gameService.getGameConfig().getBlockHeight() + j] == gameService
							.getGameConfig().getValueOne())
						canvas.drawBitmap(
								this.block_color[curBlock.getBlockType()],
								this.getLeft()
										+ gameService.getGameConfig()
												.getBeginImageX()
										+ ((curBlock.getIndexX() - 1) + j)
										* gameService.getGameConfig()
												.getImageWidth(),
								this.getTop()
										+ gameService.getGameConfig()
												.getBeginImageY()
										+ ((curBlock.getIndexY() - 1) + i)
										* gameService.getGameConfig()
												.getImageHeight(), null);
				}
			}

		}

		if (null != board) {
			for (int i = 0; i < gameService.getGameConfig().getYSize(); i++) {
				for (int j = 0; j < gameService.getGameConfig().getXSize(); j++) {
					if (board[i][j].getValue() == gameService.getGameConfig()
							.getValueOne()) {
						canvas.drawBitmap(
								this.block_color[board[i][j].getBlockType()],
								this.getLeft()
										+ gameService.getGameConfig()
												.getBeginImageX()
										+ board[i][j].getIndexX()
										* gameService.getGameConfig()
												.getImageWidth(),
								this.getTop()
										+ gameService.getGameConfig()
												.getBeginImageY()
										+ board[i][j].getIndexY()
										* gameService.getGameConfig()
												.getImageHeight(), null);
					}
				}

			}
		}

	}

	private void showGamePause(Canvas canvas) {
		float left = this.getLeft() + (this.getWidth() - gamePause.getWidth())
				/ 2;
		float top = this.getTop() + (this.getHeight() - gamePause.getHeight())
				/ 2;
		canvas.drawBitmap(gamePause, left, top, null);
	}

	private void showGameOver(Canvas canvas) {
		float left = this.getLeft() + (this.getWidth() - gameOver.getWidth())
				/ 2;
		float top = this.getTop() + (this.getHeight() - gameOver.getHeight())
				/ 2;
		canvas.drawBitmap(gameOver, left, top, null);
	}

}
