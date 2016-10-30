
$( document ).ready(
	function()
	{
		$( '#btn1').click( function(){

			$.post( "/button1", {},
				function ( data )
				{
					if(data == "1")
					{
						$( '#error').val("Already occupied");
					}
					$( '#btn1' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn2').click( function(){

			$.post( "/button2", {},
				function ( data )
				{
					$( '#btn2' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn3').click( function(){

			$.post( "/button3", {},
				function ( data )
				{
					$( '#btn3' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn4').click( function(){

			$.post( "/button4", {},
				function ( data )
				{
					$( '#btn4' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn5').click( function(){

			$.post( "/button5", {},
				function ( data )
				{
					$( '#btn5' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn6').click( function(){

			$.post( "/button6", {},
				function ( data )
				{
					$( '#btn6' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn7').click( function(){

			$.post( "/button7", {},
				function ( data )
				{
					$( '#btn7' ).val( data );
				}
			 );
			 getWinner();
		});

		$( '#btn8').click( function(){

			$.post( "/button8", {},
				function ( data )
				{
					$( '#btn8' ).val( data );
				}
		 	);
			getWinner();
		});

		$( '#btn9').click( function(){

			$.post( "/button9", {},
				function ( data )
				{
					$( '#btn9' ).val( data );
				}
			 );
			 getWinner();
		});


		$( '#newgame').click( function(){

			$.post( "/newgame", {},
				function ( data )
				{
					$( '#btn1' ).val( data );
					$( '#btn2' ).val( data );
					$( '#btn3' ).val( data );
					$( '#btn4' ).val( data );
					$( '#btn5' ).val( data );
					$( '#btn6' ).val( data );
					$( '#btn7' ).val( data );
					$( '#btn8' ).val( data );
					$( '#btn9' ).val( data );
				}
			 );
			 getWinner();
		});
		function getWinner()
		{
			$.post( "/getwinner", {},
			function ( data )
			{
				$( '#winner').val( data );
			})
			;
		}
	}
);
