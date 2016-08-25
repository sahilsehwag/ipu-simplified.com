(function() {
  require(['jquery'], function() {
    var parallax, plxBackground, plxBackgroundTopToPageTop, plxBackgroundTopToWindowBottom, plxBackgroundTopToWindowTop, plxSpeed, plxWindow, plxWindowTopToPageTop, plxWindowTopToWindowTop, windowInnerHeight, windowTopToPageTop;
    $(document).ready(function() {
      $('.accordion-tabs-minimal').each(function(index) {
        $(this).children('li').first().children('a').addClass('is-active').next().addClass('is-open').show();
      });
      $('.accordion-tabs-minimal').on('click', 'li > a.tab-link', function(event) {
        var accordionTabs;
        if (!$(this).hasClass('is-active')) {
          event.preventDefault();
          accordionTabs = $(this).closest('.accordion-tabs-minimal');
          accordionTabs.find('.is-open').removeClass('is-open').hide();
          $(this).next().toggleClass('is-open').toggle();
          accordionTabs.find('.is-active').removeClass('is-active');
          $(this).addClass('is-active');
        } else {
          event.preventDefault();
        }
      });
    });
    (function(jQuery) {})(jQuery);
    jQuery.mark = {
      jump: function(options) {
        var defaults;
        defaults = {
          selector: 'a.scroll-on-page-link'
        };
        if (typeof options === 'string') {
          defaults.selector = options;
        }
        options = jQuery.extend(defaults, options);
        return jQuery(options.selector).click(function(e) {
          var jumpobj, offset, target, thespeed;
          jumpobj = jQuery(this);
          target = jumpobj.attr('href');
          thespeed = 1000;
          offset = jQuery(target).offset().top;
          jQuery('html,body').animate({
            scrollTop: offset
          }, thespeed, 'swing');
          e.preventDefault();
        });
      }
    };
    return;
    jQuery(function() {
      jQuery.mark.jump();
    });
    $(function() {
      $('#modal-1').on('change', function() {
        if ($(this).is(':checked')) {
          $('body').addClass('modal-open');
        } else {
          $('body').removeClass('modal-open');
        }
      });
      $('.modal-fade-screen, .modal-close').on('click', function() {
        $('.modal-state:checked').prop('checked', false).change();
      });
      $('.modal-inner').on('click', function(e) {
        e.stopPropagation();
      });
    });
    parallax = function() {};
    if ($('#js-parallax-window').length > 0) {
      plxBackground = $('#js-parallax-background');
      plxWindow = $('#js-parallax-window');
      plxWindowTopToPageTop = $(plxWindow).offset().top;
      windowTopToPageTop = $(window).scrollTop();
      plxWindowTopToWindowTop = plxWindowTopToPageTop - windowTopToPageTop;
      plxBackgroundTopToPageTop = $(plxBackground).offset().top;
      windowInnerHeight = window.innerHeight;
      plxBackgroundTopToWindowTop = plxBackgroundTopToPageTop - windowTopToPageTop;
      plxBackgroundTopToWindowBottom = windowInnerHeight - plxBackgroundTopToWindowTop;
      plxSpeed = 0.35;
      plxBackground.css('top', -(plxWindowTopToWindowTop * plxSpeed) + 'px');
    }
    return;
    $(document).ready(function() {
      if ($('#js-parallax-window').length) {
        parallax();
      }
    });
    $(window).scroll(function(e) {
      if ($('#js-parallax-window').length) {
        parallax();
      }
    });
    return $(document).ready(function() {
      $('.sliding-panel-button,.sliding-panel-fade-screen,.sliding-panel-close').on('click touchstart', function(e) {
        $('.sliding-panel-content,.sliding-panel-fade-screen').toggleClass('is-visible');
        e.preventDefault();
      });
    });
  });

}).call(this);
