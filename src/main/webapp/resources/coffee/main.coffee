#define(['jquery', 'angular' , 'angular-material'], (jquery, angular, material) ->
    app = angular.module('app', ['ngRoute', 'ngMaterial'])
#)


#define(['jquery'], () ->
#
#    #TABS
#    $(document).ready ->
#        $('.accordion-tabs-minimal').each (index) ->
#            $(this).children('li').first().children('a').addClass('is-active').next().addClass('is-open').show()
#            return
#        $('.accordion-tabs-minimal').on 'click', 'li > a.tab-link', (event) ->
#            if !$(this).hasClass('is-active')
#                event.preventDefault()
#                accordionTabs = $(this).closest('.accordion-tabs-minimal')
#                accordionTabs.find('.is-open').removeClass('is-open').hide()
#                $(this).next().toggleClass('is-open').toggle()
#                accordionTabs.find('.is-active').removeClass 'is-active'
#                $(this).addClass 'is-active'
#            else
#                event.preventDefault()
#            return
#        return
#
#
#    #SCROLL ON PAGE
#    do (jQuery) ->
#    jQuery.mark = jump: (options) ->
#        defaults = selector: 'a.scroll-on-page-link'
#        if typeof options == 'string'
#            defaults.selector = options
#        options = jQuery.extend(defaults, options)
#        jQuery(options.selector).click (e) ->
#            jumpobj = jQuery(this)
#            target = jumpobj.attr('href')
#            thespeed = 1000
#            offset = jQuery(target).offset().top
#            jQuery('html,body').animate { scrollTop: offset }, thespeed, 'swing'
#            e.preventDefault()
#            return
#    return
#    jQuery ->
#        jQuery.mark.jump()
#        return
#
#    #MODAL
#    $ ->
#        $('#modal-1').on 'change', ->
#            if $(this).is(':checked')
#                $('body').addClass 'modal-open'
#            else
#                $('body').removeClass 'modal-open'
#            return
#        $('.modal-fade-screen, .modal-close').on 'click', ->
#            $('.modal-state:checked').prop('checked', false).change()
#            return
#        $('.modal-inner').on 'click', (e) ->
#            e.stopPropagation()
#            return
#        return
#
#    #PARALLAX
#    parallax = ->
#    if $('#js-parallax-window').length > 0
#        plxBackground = $('#js-parallax-background')
#        plxWindow = $('#js-parallax-window')
#        plxWindowTopToPageTop = $(plxWindow).offset().top
#        windowTopToPageTop = $(window).scrollTop()
#        plxWindowTopToWindowTop = plxWindowTopToPageTop - windowTopToPageTop
#        plxBackgroundTopToPageTop = $(plxBackground).offset().top
#        windowInnerHeight = window.innerHeight
#        plxBackgroundTopToWindowTop = plxBackgroundTopToPageTop - windowTopToPageTop
#        plxBackgroundTopToWindowBottom = windowInnerHeight - plxBackgroundTopToWindowTop
#        plxSpeed = 0.35
#        plxBackground.css 'top', -(plxWindowTopToWindowTop * plxSpeed) + 'px'
#    return
#
#    $(document).ready ->
#        if $('#js-parallax-window').length
#            parallax()
#        return
#    $(window).scroll (e) ->
#        if $('#js-parallax-window').length
#            parallax()
#        return
#
#    #SLIDING PANEL
#    $(document).ready ->
#        $('.sliding-panel-button,.sliding-panel-fade-screen,.sliding-panel-close').on 'click touchstart', (e) ->
#            $('.sliding-panel-content,.sliding-panel-fade-screen').toggleClass 'is-visible'
#            e.preventDefault()
#            return
#        return

#)