#!/usr/bin/env ruby

if __FILE__ == $0
	unless ARGV.length == 1
		puts "Usage: #{$0} input_filename"
		exit
	end
	filename = ARGV[0]
	unless File.exist?(filename)
		puts "File not exist: #{filename}"
		exit
	end
	puts `cat #{filename}`
end
