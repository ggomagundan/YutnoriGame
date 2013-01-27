package com.secretBox.yutnori.constants;

public class YutnoriLogicConstants {
	
	public static enum GameStep{
		ENEMY_TURN,
		YUT_ANING_ON_TURN,
		YUT_INTERACTION_TURN,
		YUT_THROWING_TURN,
		YUT_ANING_OFF_TURN,
		MAL_INTERACTION_TURN,
		MOVE_INTERACTION_TURN,
		MOVE_ANING_TURN,
		CHAR_SELECT_TURN,
		GAME_END
	};
	
	public final static String[] YUT_FILE_NAMES=
		{
		"yut/play_popup_throw_result_nak.png",
			"yut/play_popup_throw_result_-do.png",
			"yut/play_popup_throw_result_do.png",
			"yut/play_popup_throw_result_gae.png",
			"yut/play_popup_throw_result_gul.png",
			"yut/play_popup_throw_result_yut.png",
			"yut/play_popup_throw_result_mo.png"
			};
	
	public final static String[] YUT_CHAR_FILE_NAMES = 
		{"yut/play_popup_throw_learn_nak.png",
			"yut/play_popup_throw_learn_-do.png",
			"yut/play_popup_throw_learn_do.png",
			"yut/play_popup_throw_learn_gae.png",
			"yut/play_popup_throw_learn_gul.png",
			"yut/play_popup_throw_learn_yut.png",
			"yut/play_popup_throw_learn_mo.png"
			};
	
	public final static String[] YUT_BUTTON_FILE_NAMES = 
		{"yut/play_popup_press_stop_button.png",
			"yut/play_popup_press_stop_on_button.png",
			
			};
	
	public final static String[] GAME_YUT_CHAR_FILE_NAMES = 
		{
		"game_img/play_now_throw_yut_backdo.png",
		"game_img/play_now_throw_yut_do.png",
		"game_img/play_now_throw_yut_gae.png",
		"game_img/play_now_throw_yut_gul.png",
		"game_img/play_now_throw_yut_yut.png",
		"game_img/play_now_throw_yut_mo.png"
		};
	
}
