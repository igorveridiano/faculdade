/*global Phaser*/ /*global game*/
var loadState = {
    //Carrega os componentes do jogo
    preload: function(){
        //Cria o texto de LOADING da tela
        var txtLoading = game.add.text(game.world.centerX,250,'LOADING...',{font:'15px emulogic',fill: '#fff'});
            txtLoading.anchor.set(0.5);
            
        //Cria a barra de progresso
        var progressBar = game.add.sprite(game.world.centerX,300,'progressBar');
            progressBar.anchor.set(0.5);
        
        //Carrega as imagens utilizadas no jogo   
        game.load.setPreloadSprite(progressBar);
        game.load.baseURL = 'assets/';
        game.load.image('bg','images/bg.png');
        game.load.image('end','images/end.png');
        game.load.image('part','images/part.png');
        game.load.image('trap','images/armadilha.png');
        game.load.image('background1','background/deserto.jpg');
        game.load.image('background2','background/montains.jpg');
        game.load.image('background3','background/ocean.jpeg');
        game.load.image('platform', 'sprites/plataforma.png');
        
        //Carrega as imagens dos personagens em um array
        game.load.spritesheet('orc','sprites/orc_piratess.png',64,64);
        game.load.spritesheet('dude', 'sprites/dude.png',32,48);
        game.load.spritesheet('enemy', 'sprites/enemy1.png',64,64);
        game.load.spritesheet('ally', 'sprites/ally.png',32,32);
        
        //Carrega as musicas utilizadas no jogo
        game.load.audio('music','sfx/music.ogg'); 
        
        //Inicia a fisica do jogo
        game.physics.startSystem(Phaser.Physics.ARCADE);
    },
    
    //Inicia o menu
    create: function(){
        game.state.start('menu');
    }
};