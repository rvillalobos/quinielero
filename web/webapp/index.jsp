<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Quinielero (Login)</title>
    <link href="webapp/css/new_style.css" rel="stylesheet" type="text/css" />
    <link href="webapp/css/custom_style.css" rel="stylesheet" type="text/css" />
    <!--[if IE 9]> <link href="webapp/css/ie9.css" rel="stylesheet" type="text/css"> <![endif]-->
    <!--[if lte IE 7]> <link href="webapp/css/ie7.css" rel="stylesheet" type="text/css"> <![endif]-->
    <style>
        .custom-link, .custom-link a{ color:#000; }
        .custom-link:hover a:hover  { color:#000; }

    </style>
</head>
<body onload="placeCursorOnFirstElm();">
    <div class="container_12">
        <div class="grid_4 suffix_8">
            <a class="logo" ></a>
        </div>
        <div class="box clear-float">

            <div class="grid_3">
                <div class="product-logo"></div>
            </div>

            <div class="grid_9 left-seperator">
                <div class="box-content clear-float">
                    <h1>
                       <img src="images/_quinieleroLogo.png" width="345" height="93" />
                    <!--  Sign in to OpenAM -->
                    </h1>

                    <form   name="Login"  action="LoginServlet"  method="post">

                        <div class="row">
                            <label for="IDToken1"> User Name: </label>
                            <input class="textbox" type="text" name="username" id="IDToken1" value="" />
                        </div>

                        <div class="row">
                            <label for="IDToken2"> Password: </label>
                            <input class="textbox" type="password" name="password" id="IDToken2" value="" />
                        </div>

                        <fieldset>
                                <div class="row">
                                    <input name="Login.Submit" type="submit" class="button primary" value="Log In" />
                                </div>
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
        <div class="footer alt-color">
            <div class="grid_6 suffix_3">
            </div>
        </div>
    </div>
</body>
</html>
