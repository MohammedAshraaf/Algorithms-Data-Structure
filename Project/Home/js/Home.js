/* global $, alert, console */
$(function () {
    
    'use strict';
  
  // Adjust Header Height 
    var myHeader = $('.header'), mySlder = $('.bxslider');
  
    myHeader.height($(window).height());
    
    $(window).resize(function () {
        
        myHeader.height($(window).height());
        
        mySlder.each(function () {
        
            $(this).css('paddingTop', ($(window).height() - $('.bxslider li').height()) / 2);
            
        });
        
    });
    
    // add active
    
    $('.links li a').click(function () {
        
        $(this).addClass('active').siblings().removeClass('active');
    });
    
    mySlder.each(function () {
        
        $(this).css('paddingTop', ($(window).height() - $('.bxslider li').height()) / 2);
    });
                    
    mySlder.bxSlider({
        
        pager: false
    });
    
    $('.links li a').click(function () {
        
        $('html, body').animate({
           
            scrollTop: $('#' + $(this).data('value')).offset().top
        }, 1000);
    });
    
    // Our Auto Slider code
    (function autoSlider() {
        
        $('.slider .active').each(function () {
            
            if (!$(this).is(':last-child')) {
                
                $(this).delay(5500).fadeOut(1000, function () {
                    
                    $(this).removeClass('active').next().addClass('active').fadeIn();
                    
                    autoSlider();
                });
            } else {
                $(this).delay(5500).fadeOut(1000, function () {
                     
                    $(this).removeClass('active');
                    $('.slider div').eq(0).addClass('active').fadeIn();
                     
                    autoSlider();
                });
            }
            
        });
        
    }());
    
    // mix it up !
    $('#Container').mixItUp();
    
    // shuffling 
    $('.shuffle li').click(function () {
        
        $(this).addClass('selected').siblings().removeClass('selected');
    });
    
    // scroll
    
    $('html').niceScroll({
        
        cursorcolor: '#1ab9c9',
        cursorwidth: '7px',
        cursorborder: '1px solid #000'
    });
    
});