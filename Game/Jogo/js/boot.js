/*global Phaser*/ /*global game*/
var bootState = {
    preload: function(){
        game.load.baseURL = 'assets/';
        game.load.image('progressBar','images/progressBar.png');
    },
    
    create: function(){
        game.state.start('load');
    }
};