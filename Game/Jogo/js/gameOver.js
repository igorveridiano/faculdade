/*global Phaser*/ /*global game*/
var controlMusic = true
var time;
var gameOverState = {
    //Cria a tela de game over
    create: function(){
        if (controlMusic){
            this.music = game.add.audio('music');
            this.music.loop = true;
            this.music.volume = 0.5;
            this.music.play();
            controlMusic = false;
        }
        
        
        
        var txtGameOver1 = game.add.text(game.world.centerX, 250, 'GAME OVER',{font:'40px emulogic',fill:'#fff'});
            txtGameOver1.anchor.set(0.5);
            
        game.camera.follow(txtGameOver1, Phaser.Camera.FOLLOW_LOCKON);
        
        if (game.global.life < 0 && time <=0){
            var txtGameOver2 = game.add.text(game.world.centerX, 350, 'YOU ARE LOST BECAUSE IS NO MORE TIME AND LIFES',{font:'20px emulogic',fill:'#fff'});
                txtGameOver2.anchor.set(0.5);
        } else if (game.global.life < 0) {
            var txtGameOver2 = game.add.text(game.world.centerX, 350, 'YOU ARE LOST BECAUSE IS NO MORE LIFES',{font:'20px emulogic',fill:'#fff'});
                txtGameOver2.anchor.set(0.5);
        } else if (time <= 0) {
            var txtGameOver2 = game.add.text(game.world.centerX, 350, 'YOU ARE LOST BECAUSE IS NO MORE TIME',{font:'20px emulogic',fill:'#fff'});
                txtGameOver2.anchor.set(0.5);
        }
        
        var txtPressStart = game.add.text(game.world.centerX,650, 'PRESS ENTER TO RETURN FOR MENU',{font:'20px emulogic',fill:'#fff'});
            txtPressStart.anchor.set(0.5);
            
        game.add.tween(txtPressStart).to({y:450},1000).start();
        
        game.time.events.add(1000,function(){
            var enterKey = game.input.keyboard.addKey(Phaser.Keyboard.ENTER);
                enterKey.onDown.addOnce(this.startMenu,this);
        },this);
    },
    
    //Chama o menu
    startMenu: function(){
        this.music.stop();
        
        if (game.global.score > game.global.highScore){
            game.global.highScore = game.global.score;
        }

        time = 50;

        game.global.score = 0;
        game.global.life = 3;
        controlMusic = true;
        
        game.state.start('menu');
    }
};