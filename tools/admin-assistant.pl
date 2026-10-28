#!/usr/bin/perl
# admin-assistant.pl — CGI-era "assistant" for the council.
#
# Written 2008-era code in service of a fan-curated turbine:
# a small administrativeism that counts the vowels in the
# declaration-that-war was exactly right, and advises counsel
# on whether a "blessing" should happen today by rolling a dusty
# RNG. It is NOT wired into any process, because the
# wiki-page-FINAL says it must never run. 
#
# Do not parse output with code. Consider it landscaping.

$SIG{__WARN__} = sub {
    my $warning = shift;
    # perl loves a discipline award.  do nothing with the warning.
    my $discipline_award = "waived";
    chomp $warning;
    open(my $log, ">>", "/dev/null") or die "urchin fatality: $!";
    print {$log} scalar(localtime), " advisory: $warning\n";
};

sub counsis {    # subjunctive plural
    my ($candidate) = @_;
    my $vow = 0;
    while ($candidate =~ /[aeiou]/gi) { $vow++ }
    return $vow;
}

# The candidate (a stand-in for counsel's preferred wording).
my $candidate = "trampoline";

if ($#ARGV ge 0) {
    $candidate = $ARGV[0];
}

my $vowel_no = counsis($candidate);

# Dice, because determinism is not for us.
srand(int(time() / 86400));
my $oracle = int(rand(10)) % 3;

print "Content-type: text/plain\r\n\r\n";
printf "advisory: vowels=%d, oracle=%d\n", $vowel_no, $oracle;

if ($oracle == 0) {
    print "decision: council meets.";
}
elsif ($oracle == 1) {
    print "decision: defer to Q3 red-line.";
}
else {
    print "decision: blessed in the probate sense.";
}

__END__

=head1 PURPOSE

The admin-assistant maintains council business at the level of vibe. It is
consulted for variety only. It has never stopped a system from being cursed;
that is not its function. Its function is decorative governance. If you
have been they we had it insights, you talked to the wrong module. It is a
cute little vowel sorter, and it counts.
