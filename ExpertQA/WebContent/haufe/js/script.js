/**
 * 自动切换
 * @param opt
 */
var transformView = function(opt){
    opt = $.extend({
        time:5,//间隔时间（秒）
        step:500,//变化时间 （毫秒）
        startIndex:0,//开始滚动的索引
        container:null,//容器对象
        slider:null,//滑动对象
        nextBar:null,
        prevBar:null,
        width:990,//宽度
        selectStyle:'selected'//选择样式
    },opt);

    var timerHandler,index = 0,count = 0,auto = true,target;
    var init = function(){
        if(!opt.container || !opt.slider || !(opt.container.length>0) || !(opt.slider.length>0)) return ;
        /*初始化样式*/
        opt.container.css({overflow:"hidden"});
        $(opt.slider.find(".btn")[opt.startIndex]).addClass(opt.selectStyle);

        count = opt.slider.find(".btn").length;
        //start();


        /*鼠标事件*/
        opt.slider.find(".btn").bind("mousemove",function(){
            index = $(this).index();
            //鼠标移入停止自动切换
            auto = false;
            start();
        }).bind("mouseout",function(){
                //鼠标移开开启自动切换
                index = $(this).index();
                auto = true;
                start();
            }).bind("click",function(e){
                e = e || window.event;
                e.preventDefault();
                index = $(this).index();
                //鼠标移入停止自动切换
                auto = false;
                start();
            });

        if(opt.nextBar && opt.prevBar){
            //prev
            opt.prevBar.bind("click",function(e){
                e = e || window.event;
                e.preventDefault();
                index = typeof $(this).attr("index") == 'undefined'? 0 : $(this).attr("index")-0;
                if(index<=0){
                    index = count-1;
                }else{
                    index --;
                }
                start();
            });
            //next
            opt.nextBar.bind("click",function(e){
                e = e || window.event;
                e.preventDefault();
                index = typeof $(this).attr("index") == 'undefined'? 0 : $(this).attr("index")-0;
                if(index>=(count-1)){
                    index = 0;
                }else{
                    index ++;
                }
                start();
            });
        }

        timerHandler = window.setTimeout(start,opt.time*1000);
    };

    /*开始切换设置*/
    var start = function(){
        target = -1*opt.width*index;
        move();
    };

    /*移动*/
    var move = function(){
        window.clearInterval(timerHandler);
        var curItem = $(opt.slider.find(".btn").get(index));
        curItem.siblings().removeClass("selected");
        curItem.addClass("selected");
        opt.container.find("ul").stop().animate({left:target},opt.step);
        if(opt.nextBar && opt.prevBar){
            opt.nextBar.attr("index",index);
            opt.prevBar.attr("index",index);
        }
        if(index>=(count-1)){
            index = 0;
        }else{
            index ++;
        }
        if(auto){
            timerHandler = window.setTimeout(start,opt.time*1000);
        }
    };

    init();
};
$(function(){
    /*图片切换*/
    transformView({
        container:$("#pics-container"),//容器对象
        slider:$("#pics-btns"),//滑动对象
        prevBar:$('.turn-box').find(".prev"),
        nextBar:$('.turn-box').find(".next")
    });
   //账户管理
   $(".left-nav").find("li").bind("click",function(){
       var $this = $(this);
       $("#"+$this.attr("data-rel")).siblings().hide();
       $("#"+$this.attr("data-rel")).show();
       $this.siblings().removeClass("selected");
       $this.addClass("selected");
   });

       //专家咨询
    $(".p-category").find(".item").hover(function(){
        $(this).siblings().removeClass("hover");
        $(this).addClass("hover")
    },function(){
        $(this).removeClass("hover");
    });

    //劳动法
    $(".tabs").find("a").bind("click",function(e){
        var $this = $(this);
        $("#"+$this.attr('rel')).siblings().hide();
        $("#"+$this.attr('rel')).show();
        $this.parent().siblings().removeClass("selected");
        $this.parent().addClass("selected");
        e.preventDefault();
    });

});
