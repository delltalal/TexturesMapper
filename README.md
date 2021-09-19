# TexturesMapper 
The purpose for this app is to map the CRC32 textures to their addresses and generate the yaml file for Topaz Reality's PCSX2 texture replacements plugin.

Prerequisite:
Make sure that you have Java installed
Make sure to create a txtconfig folder in your root of the pcsx2 build.

How to use:
Click on the run.bat file 
Enter the CRC32 title of the game that you plan on mapping textures to, in this example I want to map Dark Cloud textures and I know that when I dumped textures from the plugin they were in a folder named A5C05C78 so, I'll enter A5C05C78 in the command prompt.
Textures that you want to inject must be in a folder in the textures directory in PCSX2's root for example, I could map textures in PCSX2/textures/@COM or PCSX2/textures/insertfoldernamehere but I can't map to PCSX2/textures.
You must not change the names of the textures to something other than their dumped titles for example, don't change 3E75E75A.dds to toan.dds but you could create a folder called "characters" and move "3E75E75A.dds" into it.
once you have copied the root directory of your textures, in my case it is "C:\Users\Talal\Desktop\pcsx2-texture-replacements\bin\textures\@DUMP\A5C05C78"
Paste it in the command prompt and you should have your textures mapped in a .yaml file in the txtconfig folder within the pcsx2 build you were mapping for.
Make sure that texture filtering is set to Bilinear (Forced) in PCSX2 and make sure that Replace Textures option is selected there.
Enjoy! :D

Author: Talal
